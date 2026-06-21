package com.liecoti.app.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liecoti.app.data.DataRepository
import com.liecoti.app.localization.Language
import com.liecoti.app.localization.Localization
import com.liecoti.app.localization.Strings
import com.liecoti.app.ui.admin.AdminPanel
import com.liecoti.app.ui.components.LanguagePicker
import top.yukonga.miuix.kmp.basic.*
import top.yukonga.miuix.kmp.theme.MiuixTheme

enum class Tab {
    FIRMWARES,
    RECOVERY,
    FILES,
    INSTRUCTIONS
}

@Composable
fun MainScreen(
    currentLanguage: Language,
    onLanguageChange: (Language) -> Unit
) {
    var selectedTab by remember { mutableStateOf(Tab.FIRMWARES) }
    var showAdmin by remember { mutableStateOf(false) }
    var adminPassword by remember { mutableStateOf("") }
    var showAdminDialog by remember { mutableStateOf(false) }

    val strings = Localization.current()

    val tabs = listOf(
        Tab.FIRMWARES to strings.firmwares,
        Tab.RECOVERY to strings.recovery,
        Tab.FILES to strings.files,
        Tab.INSTRUCTIONS to strings.instructions
    )

    val icons = listOf(
        MiuixIcons.VerticalSplit,
        MiuixIcons.Settings,
        MiuixIcons.Info,
        MiuixIcons.Favorites
    )

    if (showAdmin) {
        AdminPanel(onBack = { showAdmin = false })
        return
    }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = strings.appTitle
            )
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, (tab, label) ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        icon = icons[index],
                        label = label
                    )
                }
            }
        },
        floatingActionButton = {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LanguagePicker(
                    currentLanguage = currentLanguage,
                    onLanguageChange = onLanguageChange
                )

                FloatingActionButton(
                    onClick = { showAdminDialog = true }
                ) {
                    Icon(MiuixIcons.Settings, contentDescription = strings.admin)
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding())
                    .padding(horizontal = 16.dp)
            ) {
                when (selectedTab) {
                    Tab.FIRMWARES -> FirmwaresContent(strings)
                    Tab.RECOVERY -> RecoveryContent(strings)
                    Tab.FILES -> FilesContent(strings)
                    Tab.INSTRUCTIONS -> InstructionsContent(strings)
                }
            }
        }
    )

    if (showAdminDialog) {
        AlertDialog(
            onDismissRequest = { showAdminDialog = false },
            title = { Text(strings.enterPassword) },
            text = {
                OutlinedTextField(
                    value = adminPassword,
                    onValueChange = { adminPassword = it },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    if (adminPassword == "watermelon71") {
                        showAdmin = true
                        showAdminDialog = false
                        adminPassword = ""
                    }
                }) {
                    Text(strings.confirm)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showAdminDialog = false
                    adminPassword = ""
                }) {
                    Text(strings.cancel)
                }
            }
        )
    }
}

@Composable
private fun FirmwaresContent(strings: Strings) {
    LazyColumn {
        item {
            Text(
                text = strings.engineeringFirmwares,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MiuixTheme.colorScheme.onSurface,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        if (DataRepository.engineeringFirmwares.isEmpty()) {
            item {
                Text(
                    text = strings.emptyEngineering,
                    fontSize = 14.sp,
                    color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
        } else {
            items(DataRepository.engineeringFirmwares) { firmware ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    onClick = { /* Open URL */ }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = firmware.nameRu,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = MiuixTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "${strings.device}: ${firmware.deviceCodename} | ${strings.size}: ${firmware.size} | ${strings.date}: ${firmware.date}",
                            fontSize = 12.sp,
                            color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = strings.standardFirmwares,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MiuixTheme.colorScheme.onSurface,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = strings.emptyEngineering,
                fontSize = 14.sp,
                color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}

@Composable
private fun RecoveryContent(strings: Strings) {
    LazyColumn {
        items(DataRepository.recoveryFiles) { recovery ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                onClick = { /* Open URL */ }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = recovery.nameRu,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MiuixTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${strings.size}: ${recovery.size} | ${strings.date}: ${recovery.date}",
                        fontSize = 12.sp,
                        color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                    if (recovery.notes.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = recovery.notes,
                            fontSize = 12.sp,
                            color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FilesContent(strings: Strings) {
    LazyColumn {
        items(DataRepository.files) { file ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                onClick = { /* Open URL */ }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = file.nameRu,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MiuixTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${strings.size}: ${file.size} | ${strings.date}: ${file.date}",
                        fontSize = 12.sp,
                        color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                    if (file.description.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = file.description,
                            fontSize = 12.sp,
                            color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun InstructionsContent(strings: Strings) {
    LazyColumn {
        items(DataRepository.instructions) { instruction ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                onClick = { /* Open detail */ }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = instruction.titleRu,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MiuixTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = instruction.content,
                        fontSize = 12.sp,
                        color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
        }
    }
}
