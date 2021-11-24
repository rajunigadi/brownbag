import Dependencies.common

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = Versions.App.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.App.MIN_SDK
        targetSdk = Versions.App.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    kotlinOptions {
        jvmTarget = Versions.JAVA.toString()
    }
}

dependencies {
    common()
    testImplementation(Dependencies.Test.Unit.JUNIT)
}