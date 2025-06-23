plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.compose") version libs.versions.kotlin.get()
}

group = "com.example.kmpInterview"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    maven("file://$rootDir/repository")
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(projects.common)
                implementation(libs.kotlin.stdlib)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.html)
                implementation(libs.koin.core)
                implementation(libs.compose.html.core)
                implementation(libs.compose.html.svg)
                implementation(libs.compose.runtime)
            }
        }
    }
}
