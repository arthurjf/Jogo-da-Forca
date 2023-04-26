package br.com.arthurjf.jogodaforca.view.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import br.com.arthurjf.jogodaforca.R


class CreateGameDialog(context: Context, var listener: CreateGameDialogListener) : Dialog(context) {
    var buttonCancel: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_create_custom_game)

        buttonCancel = findViewById(R.id.btnCancel)

        buttonCancel?.setOnClickListener {
            cancel()
        }
    }
}