package br.com.arthurjf.jogodaforca.view.ui

import br.com.arthurjf.jogodaforca.data.Themes

interface IThemeDataProvider {
    suspend fun getThemes(): Themes
}