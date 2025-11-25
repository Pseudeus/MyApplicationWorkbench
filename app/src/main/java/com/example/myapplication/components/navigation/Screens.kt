package com.example.myapplication.components.navigation

import com.example.myapplication.components.navigation.example.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String)

@Serializable
data class Settings(val settingModel: SettingModel)