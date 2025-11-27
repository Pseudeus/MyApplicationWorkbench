package com.example.myapplication.components.navigation.types

import android.net.Uri
import android.os.Build
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.example.myapplication.components.navigation.example.model.SettingModel
import kotlinx.serialization.json.Json

val settingsModelType = object : NavType<SettingModel>(isNullableAllowed = true) {
    override fun get(
        bundle: SavedState,
        key: String
    ): SettingModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, SettingModel::class.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun serializeAsValue(value: SettingModel): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun parseValue(value: String): SettingModel {
        return Json.decodeFromString(value)
    }

    override fun put(
        bundle: SavedState,
        key: String,
        value: SettingModel
    ) {
        bundle.putParcelable(key, value)
    }
}