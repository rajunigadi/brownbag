import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {
    object Kotlin {
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:${Versions.AndroidX.CORE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Versions.Google.MATERIAL}"
    }

    object Lifecycle {
        const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    }

    object Compose {
        const val UI = "androidx.compose.ui:ui:${Versions.Compose.COMPOSE}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.Compose.COMPOSE}"
        const val PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.COMPOSE}"
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.Compose.ACTIVITY}"
        const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.Compose.FOUNDATION}"
        const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.COMPOSE}"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.Compose.COMPOSE}"
    }

    object Test {
        object Unit {
            const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        }

        object Integration {
            const val JUNIT = "androidx.test.ext:junit:${Versions.Test.JUNIT_INTEGRATION}"
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
        }
    }

    fun DependencyHandlerScope.common() {
        "implementation"(Kotlin.STDLIB)
        "implementation"(AndroidX.CORE)
        "implementation"(Lifecycle.RUNTIME)
    }

    fun DependencyHandlerScope.commonIntegrationTest() {
        "androidTestImplementation"(Test.Integration.JUNIT)
        "androidTestImplementation"(Test.Integration.ESPRESSO_CORE)
    }

    fun DependencyHandlerScope.compose() {
        "implementation"(Compose.UI)
        "implementation"(Compose.COMPOSE_MATERIAL)
        "implementation"(Compose.PREVIEW)
        "implementation"(Compose.ACTIVITY_COMPOSE)
        "debugImplementation"(Compose.UI_TOOLING)
        "androidTestImplementation"(Compose.COMPOSE_JUNIT)
        "implementation"(Compose.FOUNDATION)
    }

    fun DependencyHandlerScope.lifecycle() {
        "implementation"(Lifecycle.RUNTIME)
    }
}