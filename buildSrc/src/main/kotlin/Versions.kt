import org.gradle.api.JavaVersion

object Versions {
    object App {
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0"
        const val MIN_SDK = 21
        const val TARGET_SDK = 30
        const val COMPILE_SDK = 30
    }

    object Google {
        const val MATERIAL = "1.3.0"
    }

    object AndroidX {
        const val CORE = "1.5.0"
        const val APPCOMPAT = "1.3.0"
    }

    object Test {
        const val JUNIT = "4.13.2"
        const val JUNIT_INTEGRATION = "1.1.2"
        const val ESPRESSO = "3.3.0"
    }

    object Compose {
        const val COMPOSE = "1.0.1"
        const val FOUNDATION = "1.0.5"
        const val ACTIVITY = "1.3.1"
    }

    // Make sure to update `buildSrc/build.gradle.kts` when updating this
    const val GRADLE = "7.0.2"

    // Make sure to update `buildSrc/build.gradle.kts` when updating this
    const val KOTLIN = "1.5.21"

    val JAVA = JavaVersion.VERSION_1_8
}