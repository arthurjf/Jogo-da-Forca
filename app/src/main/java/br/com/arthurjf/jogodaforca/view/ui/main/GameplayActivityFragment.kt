package br.com.arthurjf.jogodaforca.view.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.arthurjf.jogodaforca.R

class GameplayActivityFragment : Fragment() {

    companion object {
        fun newInstance() = GameplayActivityFragment()
    }

    private lateinit var viewModel: GameplayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameplayViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_gameplay, container, false)
    }

}