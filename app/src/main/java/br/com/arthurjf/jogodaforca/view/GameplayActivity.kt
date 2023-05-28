package br.com.arthurjf.jogodaforca.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.arthurjf.jogodaforca.R
import br.com.arthurjf.jogodaforca.data.Word
import br.com.arthurjf.jogodaforca.view.ui.main.fragment.GameplayActivityFragment
import br.com.arthurjf.jogodaforca.view.ui.viewmodel.GameplayViewModel

class GameplayActivity : AppCompatActivity() {
    companion object {
        val WORD_KEY = "WORD_KEY_SENDER"
    }

    private lateinit var viewModel: GameplayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        val gameplayFragment = GameplayActivityFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, gameplayFragment)
            .commitNow()

        val wordData = intent.getParcelableExtra<Word>(WORD_KEY)

        viewModel = ViewModelProvider(this).get(GameplayViewModel::class.java)
        viewModel.wordData.value = wordData
    }
}

