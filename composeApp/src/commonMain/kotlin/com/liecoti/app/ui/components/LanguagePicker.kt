package com.liecoti.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liecoti.app.localization.Language
import com.liecoti.app.localization.Localization
import top.yukonga.miuix.kmp.basic.*
import top.yukonga.miuix.kmp.preference.ArrowPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun LanguagePicker(
    currentLanguage: Language,
    onLanguageChange: (Language) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    val strings = Localization.current()

    val languages = Language.entries
    val languageNames = listOf(
        "Русский", "English", "Polski", "Deutsch", "Türkçe"
    )

    Button(
        onClick = { showDialog = true }
    ) {
        Text(
            text = currentLanguage.displayName,
            fontSize = 14.sp
        )
    }

    if (showDialog) {
        OverlayDialog(
            title = strings.language,
            show = showDialog,
            onDismissRequest = { showDialog = false }
        ) {
            Card {
                Column {
                    languages.forEachIndexed { index, language ->
                        ArrowPreference(
                            title = languageNames[index],
                            onClick = {
                                onLanguageChange(language)
                                showDialog = false
                            }
                        )
                    }
                }
            }
        }
    }
}
