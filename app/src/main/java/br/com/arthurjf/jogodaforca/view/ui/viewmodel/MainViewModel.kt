package br.com.arthurjf.jogodaforca.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.arthurjf.jogodaforca.data.Themes
import br.com.arthurjf.jogodaforca.data.JsonThemeDataProviderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val themesRepository: JsonThemeDataProviderRepository) : ViewModel() {
    val themesLiveData = MutableLiveData<Themes>()

    fun getThemes() {
        CoroutineScope(Dispatchers.Main).launch {
            val themes = withContext(Dispatchers.Default) {
                themesRepository.getThemes()
            }

            themesLiveData.value = themes
        }
    }

    class MainViewModelFactory(private val repository: JsonThemeDataProviderRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }
}