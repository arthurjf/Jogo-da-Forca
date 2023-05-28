package br.com.arthurjf.jogodaforca.view.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.arthurjf.jogodaforca.R

class CreateGameDialog(context: Context, var listener: CreateGameDialogListener) : Dialog(context) {
    var buttonCreate: Button? = null
    var buttonCancel: Button? = null
    var fieldWord: TextView? = null
    var fieldHint: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_create_custom_game)

        buttonCreate = findViewById(R.id.btnCreateGame)
        buttonCancel = findViewById(R.id.btnCancel)
        fieldWord = findViewById(R.id.edtWord)
        fieldHint = findViewById(R.id.edtHint)

        buttonCreate?.setOnClickListener {
            listener.onCreateGame(fieldWord?.text.toString(), fieldHint?.text.toString())
        }

        buttonCancel?.setOnClickListener {
            cancel()
        }
    }
}