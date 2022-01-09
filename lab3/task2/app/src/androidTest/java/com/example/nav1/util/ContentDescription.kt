package com.example.nav1.util

import java.util.*

enum class ContentDescription(val description: String) {
    NAVUP_EN("Navigate up"),
    NAVUP_RU("Перейти вверх");

    companion object {
        private val NavUpContentDescription =
            when (Locale.getDefault().language) {
                "ru" -> NAVUP_RU
                else -> NAVUP_EN
            }

        val NavUpContentDescriptionValue = NavUpContentDescription.description
    }
}