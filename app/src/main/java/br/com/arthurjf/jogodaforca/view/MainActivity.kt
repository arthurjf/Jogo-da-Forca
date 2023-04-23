package br.com.arthurjf.jogodaforca.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.arthurjf.jogodaforca.R
import br.com.arthurjf.jogodaforca.view.ui.main.MainActivityFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainActivityFragment.newInstance())
                .commitNow()
        }
    }
}