package br.com.arthurjf.jogodaforca.data

import android.content.Context
import br.com.arthurjf.jogodaforca.view.ui.IThemeDataProvider
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JsonThemeDataProviderRepository(private val context: Context) : IThemeDataProvider {
    override suspend fun getThemes(): Themes {
        return withContext(Dispatchers.Default){
            val gson = Gson()
            val json = context.assets.open("words.json")
                .bufferedReader()
                .use { it.readText() }
            gson.fromJson(json, Themes::class.java)
        }
    }
}