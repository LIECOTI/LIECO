package com.liecoti.app.data

import kotlinx.serialization.Serializable

@Serializable
data class FirmwareItem(
    val id: String,
    val nameRu: String,
    val nameEn: String,
    val size: String,
    val date: String,
    val deviceCodename: String,
    val downloadUrl: String
)

@Serializable
data class RecoveryItem(
    val id: String,
    val nameRu: String,
    val nameEn: String,
    val size: String,
    val date: String,
    val downloadUrl: String,
    val notes: String = ""
)

@Serializable
data class FileItem(
    val id: String,
    val nameRu: String,
    val nameEn: String,
    val size: String,
    val date: String,
    val downloadUrl: String,
    val description: String = ""
)

@Serializable
data class InstructionItem(
    val id: String,
    val titleRu: String,
    val titleEn: String,
    val content: String
)
