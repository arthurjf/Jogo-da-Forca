package br.com.arthurjf.jogodaforca.view.ui.main.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import br.com.arthurjf.jogodaforca.R
import br.com.arthurjf.jogodaforca.data.ThemesRepository
import br.com.arthurjf.jogodaforca.data.Word
import br.com.arthurjf.jogodaforca.view.GameplayActivity
import br.com.arthurjf.jogodaforca.view.ui.CreateGameDialog
import br.com.arthurjf.jogodaforca.view.ui.CreateGameDialogListener
import br.com.arthurjf.jogodaforca.view.ui.viewmodel.MainViewModel
import com.jaredrummler.materialspinner.MaterialSpinner

class MainActivityFragment : Fragment() {

    private var buttonCreateGame: Button? = null
    private var buttonPlay: Button? = null
    private var spinner: MaterialSpinner? = null

    companion object {
        fun newInstance() = MainActivityFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(
                this,
                MainViewModel.MainViewModelFactory(ThemesRepository(requireContext()))
            )[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getThemes()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        spinner = view.findViewById(R.id.spinnerTheme)

        viewModel.themesLiveData.observe(viewLifecycleOwner) { themes ->
            val themesList = themes.themes.map { it.name }
            val adapter =
                ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, themesList)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner?.setAdapter(adapter)
        }

        buttonPlay = view.findViewById(R.id.btnPlay)
        buttonCreateGame = view.findViewById(R.id.btnCreate)

        buttonCreateGame?.setOnClickListener {
            CreateGameDialog(requireContext(), object : CreateGameDialogListener {
                override fun onCreateGame(word: String, hint: String) {

                }
            }).show()
        }

        buttonPlay?.setOnClickListener {
            val selectedTheme = spinner?.selectedIndex?.let {
                viewModel.themesLiveData.value?.themes?.get(it)
            }

            selectedTheme?.words?.let { callGameplayScreen(it.random()) }
        }

        return view
    }

    private fun callGameplayScreen(wordData: Word) {
        val intent = Intent(requireContext(), GameplayActivity::class.java)
        intent.putExtra(GameplayActivity.WORD_KEY, wordData)
        startActivity(intent)
        requireActivity().finish()
    }
}