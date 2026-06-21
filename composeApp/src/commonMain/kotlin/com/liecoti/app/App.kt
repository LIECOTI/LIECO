package com.liecoti.app

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.liecoti.app.localization.Language
import com.liecoti.app.localization.LocalLanguage
import com.liecoti.app.theme.AppTheme
import com.liecoti.app.ui.intro.IntroScreen
import com.liecoti.app.ui.main.MainScreen

@androidx.compose.runtime.Composable
fun App() {
    var language by remember { mutableStateOf(Language.RU) }
    var showIntro by remember { mutableStateOf(true) }

    CompositionLocalProvider(LocalLanguage provides language) {
        AppTheme {
            if (showIntro) {
                IntroScreen(onStart = { showIntro = false })
            } else {
                MainScreen(
                    currentLanguage = language,
                    onLanguageChange = { language = it }
                )
            }
        }
    }
}
