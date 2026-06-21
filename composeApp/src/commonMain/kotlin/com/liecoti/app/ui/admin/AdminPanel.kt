package com.liecoti.app.ui.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liecoti.app.data.*
import com.liecoti.app.localization.Localization
import top.yukonga.miuix.kmp.basic.*
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun AdminPanel(onBack: () -> Unit) {
    val strings = Localization.current()
    var showAddFirmware by remember { mutableStateOf(false) }
    var showAddRecovery by remember { mutableStateOf(false) }
    var showAddFile by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = strings.admin,
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(MiuixIcons.Back, contentDescription = "Back")
                    }
                }
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding())
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { showAddFirmware = true },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(strings.addFirmware)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = { showAddRecovery = true },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(strings.addRecovery)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = { showAddFile = true },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(strings.addFile)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = strings.engineeringFirmwares,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MiuixTheme.colorScheme.onSurface
                    )
                }

                items(DataRepository.engineeringFirmwares) { firmware ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = firmware.nameRu,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = MiuixTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${firmware.deviceCodename} | ${firmware.size}",
                                fontSize = 12.sp,
                                color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = strings.recovery,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MiuixTheme.colorScheme.onSurface
                    )
                }

                items(DataRepository.recoveryFiles) { recovery ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = recovery.nameRu,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = MiuixTheme.colorScheme.onSurface
                            )
                            Text(
                                text = recovery.size,
                                fontSize = 12.sp,
                                color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = strings.files,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MiuixTheme.colorScheme.onSurface
                    )
                }

                items(DataRepository.files) { file ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = file.nameRu,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = MiuixTheme.colorScheme.onSurface
                            )
                            Text(
                                text = file.size,
                                fontSize = 12.sp,
                                color = MiuixTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                    }
                }
            }
        }
    )

    if (showAddFirmware) {
        AddFirmwareDialog(
            onDismiss = { showAddFirmware = false },
            onAdd = { firmware ->
                DataRepository.engineeringFirmwares.add(firmware)
                showAddFirmware = false
            }
        )
    }

    if (showAddRecovery) {
        AddRecoveryDialog(
            onDismiss = { showAddRecovery = false },
            onAdd = { recovery ->
                DataRepository.recoveryFiles.add(recovery)
                showAddRecovery = false
            }
        )
    }

    if (showAddFile) {
        AddFileDialog(
            onDismiss = { showAddFile = false },
            onAdd = { file ->
                DataRepository.files.add(file)
                showAddFile = false
            }
        )
    }
}

@Composable
private fun AddFirmwareDialog(
    onDismiss: () -> Unit,
    onAdd: (FirmwareItem) -> Unit
) {
    val strings = Localization.current()
    var name by remember { mutableStateOf("") }
    var device by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }

    OverlayDialog(
        title = strings.addFirmware,
        show = true,
        onDismissRequest = onDismiss
    ) {
        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = device,
                    onValueChange = { device = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = size,
                    onValueChange = { size = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = url,
                    onValueChange = { url = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(text = strings.cancel, onClick = onDismiss)
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            onAdd(
                                FirmwareItem(
                                    id = "custom-${System.currentTimeMillis()}",
                                    nameRu = name,
                                    nameEn = name,
                                    size = size,
                                    date = "Now",
                                    deviceCodename = device,
                                    downloadUrl = url
                                )
                            )
                        },
                        colors = ButtonDefaults.buttonColorsPrimary()
                    ) {
                        Text(strings.save)
                    }
                }
            }
        }
    }
}

@Composable
private fun AddRecoveryDialog(
    onDismiss: () -> Unit,
    onAdd: (RecoveryItem) -> Unit
) {
    val strings = Localization.current()
    var name by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    OverlayDialog(
        title = strings.addRecovery,
        show = true,
        onDismissRequest = onDismiss
    ) {
        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = size,
                    onValueChange = { size = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = url,
                    onValueChange = { url = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = notes,
                    onValueChange = { notes = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(text = strings.cancel, onClick = onDismiss)
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            onAdd(
                                RecoveryItem(
                                    id = "custom-${System.currentTimeMillis()}",
                                    nameRu = name,
                                    nameEn = name,
                                    size = size,
                                    date = "Now",
                                    downloadUrl = url,
                                    notes = notes
                                )
                            )
                        },
                        colors = ButtonDefaults.buttonColorsPrimary()
                    ) {
                        Text(strings.save)
                    }
                }
            }
        }
    }
}

@Composable
private fun AddFileDialog(
    onDismiss: () -> Unit,
    onAdd: (FileItem) -> Unit
) {
    val strings = Localization.current()
    var name by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    OverlayDialog(
        title = strings.addFile,
        show = true,
        onDismissRequest = onDismiss
    ) {
        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = size,
                    onValueChange = { size = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = url,
                    onValueChange = { url = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(text = strings.cancel, onClick = onDismiss)
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            onAdd(
                                FileItem(
                                    id = "custom-${System.currentTimeMillis()}",
                                    nameRu = name,
                                    nameEn = name,
                                    size = size,
                                    date = "Now",
                                    downloadUrl = url,
                                    description = description
                                )
                            )
                        },
                        colors = ButtonDefaults.buttonColorsPrimary()
                    ) {
                        Text(strings.save)
                    }
                }
            }
        }
    }
}
