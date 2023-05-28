package br.com.arthurjf.jogodaforca.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Word(
    val word: String,
    val hint: String
) : Parcelable