package br.com.arthurjf.jogodaforca.view.ui.main.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.arthurjf.jogodaforca.R
import br.com.arthurjf.jogodaforca.view.ui.viewmodel.GameplayViewModel

class GameplayActivityFragment : Fragment() {

    companion object {
        fun newInstance() = GameplayActivityFragment()
    }

    private lateinit var viewModel: GameplayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[GameplayViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_gameplay, container, false)

        viewModel.wordData.observe(viewLifecycleOwner) { word ->
            view.findViewById<TextView>(R.id.textTest).text = word.word
        }

        return view
    }

}