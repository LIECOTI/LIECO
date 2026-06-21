package com.liecoti.app.data

import androidx.compose.runtime.mutableStateListOf

object DataRepository {
    val engineeringFirmwares = mutableStateListOf(
        FirmwareItem(
            id = "mi-9t-eng-rom",
            nameRu = "Инженерная прошивка MI 9T (davinci)",
            nameEn = "Engineering ROM MI 9T (davinci)",
            size = "0.97 GB",
            date = "17.12.2025",
            deviceCodename = "davinci",
            downloadUrl = "https://t.me/weco14/17"
        ),
        FirmwareItem(
            id = "mi-9t-pro",
            nameRu = "Mi 9T Pro / Redmi K20 Pro",
            nameEn = "Mi 9T Pro or Redmi K20 Pro",
            size = "1.3 GB",
            date = "18.12.2025",
            deviceCodename = "raphael",
            downloadUrl = "https://devuploads.com/430nir6wcvb8"
        ),
        FirmwareItem(
            id = "rn-5-a-ugg",
            nameRu = "Redmi Note 5A (UGG)",
            nameEn = "Redmi Note 5A (UGG)",
            size = "750.1 MB",
            date = "18.12.2025",
            deviceCodename = "ugg",
            downloadUrl = "https://devuploads.com/1srxuqbigylp"
        ),
        FirmwareItem(
            id = "xiaomi-12",
            nameRu = "Xiaomi 12 (Cupid)",
            nameEn = "Xiaomi 12 (Cupid)",
            size = "1.9 GB",
            date = "18.12.2025",
            deviceCodename = "cupid",
            downloadUrl = "https://devuploads.com/4fx68v7ro4kb"
        )
    )

    val standardFirmwares = mutableStateListOf<FirmwareItem>()

    val recoveryFiles = mutableStateListOf(
        RecoveryItem(
            id = "ofox",
            nameRu = "OrangeFox Recovery Retrofit для tucana",
            nameEn = "OrangeFox Recovery Retrofit for tucana",
            size = "266 MB",
            date = "05.07.2026",
            downloadUrl = "https://drive.google.com/file/d/1Nw8nA-05pw5ekniBSR0HSEq6VwRlGGBm/view?usp=drive_link",
            notes = "Кастомное recovery с A12+ retrofit. Перезагрузка через «reboot to system» или выключение питания."
        ),
        RecoveryItem(
            id = "mi-account-bypass",
            nameRu = "Обход блокировки Mi Account",
            nameEn = "Mi Account Bypass Tool",
            size = "891 KB",
            date = "10.12.2025",
            downloadUrl = "Mi-Acccount.Bypass.in.sideload.mode.rar",
            notes = "Работает только на устройствах Snapdragon с MIUI 12."
        )
    )

    val files = mutableStateListOf(
        FileItem(
            id = "engd",
            nameRu = "ENGD 2.0.0",
            nameEn = "ENGD 2.0.0",
            size = "114 MB",
            date = "14.02.2026",
            downloadUrl = "https://github.com/LIECOTI/ENGD/releases/download/v2.0.0/ENGD_Setup.msi",
            description = "UI программа для ADB/Fastboot операций."
        ),
        FileItem(
            id = "superwallpaper",
            nameRu = "Суперобои",
            nameEn = "Super Wallpapers",
            size = "46.3 MB",
            date = "15.12.2025",
            downloadUrl = "https://t.me/weco14/14",
            description = "Коллекция версий Mi Wallpaper."
        ),
        FileItem(
            id = "hyperceiler",
            nameRu = "HyperCeiler",
            nameEn = "HyperCeiler",
            size = "4.5 MB",
            date = "01.12.2025",
            downloadUrl = "https://t.me/weco14/49",
            description = "Последний HyperCeiler для MIUI 12 и Android 11."
        )
    )

    val instructions = mutableStateListOf(
        InstructionItem(
            id = "how-to-flash",
            titleRu = "Как прошить Xiaomi через Fastboot",
            titleEn = "How to flash Xiaomi via Fastboot",
            content = "Полное руководство по прошивке ROM через MiFlash. Требуется разблокированный бутлоадер, Fastboot режим и инструмент MiFlash."
        )
    )
}
