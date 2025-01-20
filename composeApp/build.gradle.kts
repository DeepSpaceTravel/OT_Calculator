import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.sqldelight)
//    I added this
//    kotlin("plugin.serialization") version "2.0.21"
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }

    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = false
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.splashscreen)
//            SQLDelight
            implementation(libs.android.driver)
//            Koin
            implementation(libs.koin.androidx.compose)
//            Navigation
//            implementation(libs.navigation.compose)
        }

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
//            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.animation)
            implementation(compose.animationGraphics)
            implementation(compose.materialIconsExtended)
//            Datetime
            implementation(libs.kotlinx.date.time)
            implementation(libs.lifecycle.viewmodel.compose)
//            SQLDelight
            implementation(libs.runtime)
//            Koin
            implementation(libs.koin.core)
//            Animation
//            implementation(libs.androidx.animation)
//            Navigation
            implementation(libs.navigation.compose)


//            Voyager
//            implementation(libs.voyager.navigator)
//            implementation(libs.voyager.screenModel)
//            implementation(libs.voyager.transitions)

//            Kermit the Logging
            implementation(libs.kermit)
        }

        iosMain.dependencies {
//            SQLDelight
            implementation(libs.native.driver)
        }
    }
}

android {
    namespace = "org.example.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.example.project"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21

    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

//SQL-Delight Database
sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("org.example.project")
        }
    }
}