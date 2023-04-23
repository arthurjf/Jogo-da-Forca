package br.com.arthurjf.jogodaforca.view.ui.main.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.com.arthurjf.jogodaforca.R
import br.com.arthurjf.jogodaforca.data.ThemesRepository
import br.com.arthurjf.jogodaforca.view.ui.viewmodel.MainViewModel
import com.jaredrummler.materialspinner.MaterialSpinner

class MainActivityFragment : Fragment() {

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
        val spinner = view.findViewById<MaterialSpinner>(R.id.spinnerTheme)

        viewModel.themesLiveData.observe(viewLifecycleOwner) { themes ->
            val themesList = themes.themes.map { it.name }
            val adapter =
                ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, themesList)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.setAdapter(adapter)
        }

        return view
    }

}