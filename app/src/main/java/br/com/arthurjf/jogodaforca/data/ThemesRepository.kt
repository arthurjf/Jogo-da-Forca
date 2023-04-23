package br.com.arthurjf.jogodaforca.data

import android.content.Context
import com.google.gson.Gson

class ThemesRepository(private val context: Context) {
    fun getThemes(callback: (themes: Themes) -> Unit) {
        Thread {
            val gson = Gson()
            val json = context.assets.open("words.json")
                .bufferedReader()
                .use { it.readText() }
            val themes = gson.fromJson(json, Themes::class.java)
            callback.invoke(themes)
        }.start()
    }
}