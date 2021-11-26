// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("io.gitlab.arturbosch.detekt").version("1.16.0")
    id("org.jlleitschuh.gradle.ktlint").version("10.2.0")
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.register("installGitHook", Copy::class) {
    from(file("${rootProject.rootDir}/pre-commit"))
    into(file("${rootProject.rootDir}.git/hooks"))
    fileMode = 777
}

tasks.getByPath(":app:preBuild").dependsOn(tasks.getByPath("installGitHook"))
tasks.getByPath(":app:clean").dependsOn(tasks.getByPath("installGitHook"))
tasks.getByPath(":app:assemble").dependsOn(tasks.getByPath("installGitHook"))

/*task installGitHook(type: Copy) {
    from new File(rootProject.rootDir, 'pre-commit')
    into { new File(rootProject.rootDir, '.git/hooks') }
    fileMode 0777
}*/

//tasks.getByPath(':app:preBuild').dependsOn installGitHook
//tasks.getByPath(':app:clean').dependsOn installGitHook 
//tasks.getByPath(':app:assemble').dependsOn installGitHook
