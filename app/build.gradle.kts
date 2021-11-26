import Dependencies.common
import Dependencies.commonIntegrationTest
import Dependencies.compose

plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
}

android {
    compileSdk = Versions.App.COMPILE_SDK

    defaultConfig {
        applicationId = "com.android.brownbag"
        minSdk = Versions.App.MIN_SDK
        targetSdk = Versions.App.TARGET_SDK
        versionCode = Versions.App.VERSION_CODE
        versionName = Versions.App.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        setProperty("archivesBaseName", "Brownbag-$versionName($versionCode)")
    }

    /*signingConfigs {
        create("release") {
            val alias: String by project
            val aliasPassword: String by project
            val password: String by project
            storeFile = file("${project.rootDir}/keystore/brownbag.jks")
            storePassword = password
            keyAlias = alias
            keyPassword = aliasPassword
        }
    }*/

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            //signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    kotlinOptions {
        jvmTarget = Versions.JAVA.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    lint {
        isCheckDependencies = true
        xmlReport = false
        htmlReport = true
        htmlOutput = file("${project.rootDir}/build/reports/android-lint.html")
    }
}

dependencies {
    implementation(project(Modules.FEATURE1))
    implementation(project(Modules.FEATURE2))
    common()
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.Google.MATERIAL)
    compose()
    testImplementation(Dependencies.Test.Unit.JUNIT)
    commonIntegrationTest()
}