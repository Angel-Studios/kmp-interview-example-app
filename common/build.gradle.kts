plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.compose") version libs.versions.kotlin.get()
    id("com.apollographql.apollo") version libs.versions.apollo.get()
    id("maven-publish")
}

kotlin {
    js(IR) {
        useEsModules()
        browser()
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.compose.runtime)
                implementation(libs.koin.core)
                implementation(libs.apollo.runtime)
            }
        }
    }
}

apollo {
    service("rocketreserver") {
        generateKotlinModels.set(true)
        schemaFile.set(file("./src/commonMain/graphql/rocketreserver/schema.graphqls"))
        generateApolloMetadata.set(true)
        generateAsInternal.set(false)
        alwaysGenerateTypesMatching.set(listOf(".*"))
        sourceFolder.set("rocketreserver")
        packageName.set("com.example.kmpInterview.graphql.rocketreserver")
        useSemanticNaming.set(true)
    }
}
