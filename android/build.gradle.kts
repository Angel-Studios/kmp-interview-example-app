import com.android.build.gradle.internal.api.BaseVariantOutputImpl

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.application")
    kotlin("multiplatform")
    id("org.jetbrains.compose") version libs.versions.compose.get()
}

android {
    namespace = "com.example.kmpInterview"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.kmpInterview"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()

        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        resourceConfigurations.addAll(
            listOf("en")
        )
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }

    signingConfigs {
        create("release") {
            if(System.getenv("KSTOREFILE") != null) {
                storeFile = File(System.getenv("KSTOREFILE"))
            }

            storePassword = System.getenv("KSTOREPWD")
            keyAlias = System.getenv("KEYALIAS")
            keyPassword = System.getenv("KEYPWD")
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            manifestPlaceholders["appName"] = "@string/app_name_debug"
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles.add(getDefaultProguardFile("proguard-android.txt"))
            proguardFiles.add(File("proguard-rules.pro"))
            signingConfig = signingConfigs.getByName("release")
            manifestPlaceholders["appName"] = "@string/app_name"

            applicationVariants.all {
                outputs.map { it as BaseVariantOutputImpl }
                    .forEach { output ->
                        output.outputFileName = "${project.parent?.name}-${defaultConfig.versionName}.apk"
                    }
            }
        }
    }

    lint {
        abortOnError = false
    }
}

kotlin {
    android()
}

dependencies {
    implementation(projects.common)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.androidx)
    implementation(libs.bundles.koin)
    implementation(libs.coil.compose)
}