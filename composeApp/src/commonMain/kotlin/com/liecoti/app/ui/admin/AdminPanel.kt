package com.liecoti.app.ui.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liecoti.app.data.*
import com.liecoti.app.localization.Localization
import kotlin.time.TimeSource
import top.yukonga.miuix.kmp.basic.*
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun AdminPanel(onBack: () -> Unit) {
    val strings = Localization.current()
    var showAddFirmware by remember { mutableStateOf<Boolean>(false) }
    var showAddRecovery by remember { mutableStateOf<Boolean>(false) }
    var showAddFile by remember { mutableStateOf<Boolean>(false) }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = strings.admin,
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
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
    var name by remember { mutableStateOf<String>("") }
    var device by remember { mutableStateOf<String>("") }
    var size by remember { mutableStateOf<String>("") }
    var url by remember { mutableStateOf<String>("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(strings.addFirmware) },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(strings.name) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = device,
                    onValueChange = { device = it },
                    label = { Text(strings.device) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = size,
                    onValueChange = { size = it },
                    label = { Text(strings.size) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = url,
                    onValueChange = { url = it },
                    label = { Text(strings.url) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onAdd(
                    FirmwareItem(
                        id = "custom-${TimeSource.Monotonic.markNow().elapsedNow().inWholeMilliseconds}",
                        nameRu = name,
                        nameEn = name,
                        size = size,
                        date = "Now",
                        deviceCodename = device,
                        downloadUrl = url
                    )
                )
            }) {
                Text(strings.save)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(strings.cancel)
            }
        }
    )
}

@Composable
private fun AddRecoveryDialog(
    onDismiss: () -> Unit,
    onAdd: (RecoveryItem) -> Unit
) {
    val strings = Localization.current()
    var name by remember { mutableStateOf<String>("") }
    var size by remember { mutableStateOf<String>("") }
    var url by remember { mutableStateOf<String>("") }
    var notes by remember { mutableStateOf<String>("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(strings.addRecovery) },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(strings.name) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = size,
                    onValueChange = { size = it },
                    label = { Text(strings.size) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = url,
                    onValueChange = { url = it },
                    label = { Text(strings.url) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text(strings.notes) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onAdd(
                    RecoveryItem(
                        id = "custom-${TimeSource.Monotonic.markNow().elapsedNow().inWholeMilliseconds}",
                        nameRu = name,
                        nameEn = name,
                        size = size,
                        date = "Now",
                        downloadUrl = url,
                        notes = notes
                    )
                )
            }) {
                Text(strings.save)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(strings.cancel)
            }
        }
    )
}

@Composable
private fun AddFileDialog(
    onDismiss: () -> Unit,
    onAdd: (FileItem) -> Unit
) {
    val strings = Localization.current()
    var name by remember { mutableStateOf<String>("") }
    var size by remember { mutableStateOf<String>("") }
    var url by remember { mutableStateOf<String>("") }
    var description by remember { mutableStateOf<String>("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(strings.addFile) },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(strings.name) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = size,
                    onValueChange = { size = it },
                    label = { Text(strings.size) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = url,
                    onValueChange = { url = it },
                    label = { Text(strings.url) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text(strings.description) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onAdd(
                    FileItem(
                        id = "custom-${TimeSource.Monotonic.markNow().elapsedNow().inWholeMilliseconds}",
                        nameRu = name,
                        nameEn = name,
                        size = size,
                        date = "Now",
                        downloadUrl = url,
                        description = description
                    )
                )
            }) {
                Text(strings.save)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(strings.cancel)
            }
        }
    )
}
