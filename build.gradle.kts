// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version by extra("1.0.1")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // groovy
        /*classpath "com.android.tools.build:gradle:7.0.2"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21"*/

        // kotlin dsl
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

// groovy
/*task clean(type: Delete) {
    delete rootProject.buildDir
}*/

// kotlin dsl
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}