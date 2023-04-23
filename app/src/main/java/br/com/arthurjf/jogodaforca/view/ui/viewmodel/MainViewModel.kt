package br.com.arthurjf.jogodaforca.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.arthurjf.jogodaforca.data.ThemesRepository
import br.com.arthurjf.jogodaforca.data.Themes

class MainViewModel(private val wordsRepository: ThemesRepository) : ViewModel() {
    val themesLiveData = MutableLiveData<Themes>()

    fun getThemes() {
        wordsRepository.getThemes() { themes ->
            themesLiveData.postValue(themes)
        }
    }

    class MainViewModelFactory(private val repository: ThemesRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }
}