package br.com.arthurjf.jogodaforca.data

import android.content.Context
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ThemesRepository(private val context: Context) {
    suspend fun getThemes(): Themes {
        return withContext(Dispatchers.Default){
            val gson = Gson()
            val json = context.assets.open("words.json")
                .bufferedReader()
                .use { it.readText() }
            gson.fromJson(json, Themes::class.java)
        }
    }
}