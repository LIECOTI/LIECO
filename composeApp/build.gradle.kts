import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            binaries.executable()
        }
    }

    jvm("desktop")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")

                implementation("top.yukonga.miuix.kmp:miuix-ui:0.3.0")
                implementation("top.yukonga.miuix.kmp:miuix-preference:0.3.0")
                implementation("top.yukonga.miuix.kmp:miuix-icons:0.3.0")
                implementation("top.yukonga.miuix.kmp:miuix-squircle:0.3.0")
            }
        }

        val desktopMain by getting
    }
}

compose.desktop {
    application {
        mainClass = "com.liecoti.app.MainKt"
    }
}
