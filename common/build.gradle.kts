import org.jetbrains.compose.compose

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version libs.versions.compose.get()
    id("com.apollographql.apollo3") version libs.versions.apollo.get()
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
                api(compose.runtime)
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
        generateAsInternal.set(true)
        alwaysGenerateTypesMatching.set(listOf(".*"))
        sourceFolder.set("rocketreserver")
        packageName.set("com.example.kmpInterview.graphql.rocketreserver")
        useSemanticNaming.set(true)
    }
}
