import Dependencies.commonIntegrationTest
import Dependencies.compose

plugins {
    id(Plugins.COMMON)
}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE
    }
}

dependencies {
    implementation(Dependencies.Google.MATERIAL)
    compose()
    commonIntegrationTest()
}