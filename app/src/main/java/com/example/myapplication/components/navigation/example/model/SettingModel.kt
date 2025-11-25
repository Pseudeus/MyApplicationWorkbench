package com.example.myapplication.components.navigation.example.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SettingModel(
    val id: String,
    val darkMode: Boolean
) : Parcelable
