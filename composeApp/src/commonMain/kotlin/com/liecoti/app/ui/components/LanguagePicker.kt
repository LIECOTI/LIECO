package com.liecoti.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liecoti.app.localization.Language
import com.liecoti.app.localization.Localization
import top.yukonga.miuix.kmp.basic.*
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun LanguagePicker(
    currentLanguage: Language,
    onLanguageChange: (Language) -> Unit
) {
    var showDialog by remember { mutableStateOf<Boolean>(false) }
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
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(strings.language) },
            text = {
                Column {
                    languages.forEachIndexed { index, language ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.dp),
                            onClick = {
                                onLanguageChange(language)
                                showDialog = false
                            }
                        ) {
                            Text(
                                text = languageNames[index],
                                modifier = Modifier.padding(16.dp),
                                color = if (language == currentLanguage)
                                    MiuixTheme.colorScheme.primary
                                else
                                    MiuixTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(strings.cancel)
                }
            }
        )
    }
}
