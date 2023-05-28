package br.com.arthurjf.jogodaforca.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.arthurjf.jogodaforca.data.Word

class GameplayViewModel : ViewModel() {
    val wordData = MutableLiveData<Word>()
}