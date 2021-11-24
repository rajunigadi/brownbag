import Dependencies.common
import Dependencies.commonIntegrationTest
import Dependencies.compose

plugins {
    // groovy
    /*id 'com.android.application'
    id 'kotlin-android'*/

    // kotlin-dsl
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
}

android {
    // groovy
    /*compileSdk 31*/

    // kotlin-dsl
    compileSdk = Versions.App.COMPILE_SDK

    defaultConfig {
        // groovy
        /*applicationId "com.android.brownbag"
        minSdk 21
        targetSdk 31
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }*/

        // kotlin-dsl
        applicationId = "com.android.brownbag"
        minSdk = Versions.App.MIN_SDK
        targetSdk = Versions.App.TARGET_SDK
        versionCode = Versions.App.VERSION_CODE
        versionName = Versions.App.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    // groovy
    /*buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }*/
    // kotlin-dsl
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // groovy
    /*compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }*/
    // kotlin-dsl
    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    // groovy
    /*kotlinOptions {
        jvmTarget = '1.8'
        useIR = true
    }*/
    // kotlin-dsl
    kotlinOptions {
        jvmTarget = Versions.JAVA.toString()
        useIR = true
    }

    // groovy
    /*buildFeatures {
        compose true
    }*/
    // kotlin-dsl
    buildFeatures {
        compose = true
    }

    // groovy
    /*composeOptions {
        kotlinCompilerExtensionVersion "1.0.1"
        kotlinCompilerVersion '1.5.21'
    }*/
    // kotlin-dsl
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE
        kotlinCompilerVersion = Versions.KOTLIN
    }

    // groovy
    /*packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }*/
    // kotlin-dsl
    packagingOptions {
        resources {
            excludes.add("'/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    // groovy
    /*implementation 'androidx.core:core-ktx:1.6.0'
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    // compose
    implementation "androidx.compose.ui:ui:1.0.1"
    implementation "androidx.compose.material:material:1.0.1"
    implementation "androidx.compose.ui:ui-tooling-preview:1.0.1"

    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
    implementation 'androidx.activity:activity-compose:1.3.1'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:1.0.1"
    debugImplementation "androidx.compose.ui:ui-tooling:1.0.1"*/

    // kotlin-dsl
    implementation(project(Modules.FEATURE1))
    implementation(project(Modules.FEATURE2))
    common()
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.Google.MATERIAL)
    compose()
    testImplementation(Dependencies.Test.Unit.JUNIT)
    commonIntegrationTest()
}