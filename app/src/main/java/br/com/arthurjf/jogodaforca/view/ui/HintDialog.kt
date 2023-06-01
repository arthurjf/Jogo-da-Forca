package br.com.arthurjf.jogodaforca.view.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.arthurjf.jogodaforca.R
import br.com.arthurjf.jogodaforca.view.ui.viewmodel.GameplayViewModel

class HintDialog(context: Context, val viewModel: GameplayViewModel) : Dialog(context) {

    var textHint: TextView? = null
    var buttonClose: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_hint)

        textHint = findViewById(R.id.txtGameplayHint)
        buttonClose = findViewById(R.id.btnClose)

        textHint?.text = viewModel.wordData.value?.hint

        buttonClose?.setOnClickListener {
            cancel()
        }
    }
}