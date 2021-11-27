import java.util.Locale

// Top-level build file where you can add configuration options common to all sub-projects/modules.
apply {
    //from("${rootDir}/git-hooks.gradle")
}
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

/*tasks.register("installGitHooks", Copy::class) {
    from(file("${rootProject.rootDir}/props/git-hooks/pre-commit"))
    into(file("${rootProject.rootDir}.git/hooks"))
    fileMode = 777
}*/

fun isLinuxOrMacOs(): Boolean {
    val osName = System.getProperty("os.name").toLowerCase(Locale.ROOT)
    return osName.contains("linux") || osName.contains("mac os") || osName.contains("macos")
}

tasks.register("copyGitHooks", Copy::class) {
    description = "Copies the git hooks from props/git-hooks to the .git folder."
    from("${rootDir}/props/git-hooks/") {
        include("**/*.sh")
        rename("(.*).sh", "$1")
    }
    into("${rootDir}/.git/hooks")
    onlyIf { isLinuxOrMacOs() }
}

tasks.register("installGitHooks") {
    description = "Installs the pre-commit git hooks from team-props/git-hooks."
    group = "git hooks"
    exec {
        workingDir(rootDir)
        commandLine.add("chmod")
        args?.addAll(listOf<String>("-R", "+x", ".git/hooks/"))
        dependsOn("copyGitHooks")
        onlyIf { isLinuxOrMacOs() }
    }
    doLast {
        println("Git hook installed successfully.")
    }
}

afterEvaluate {
    // We install the hook at the first occasion
    tasks["clean"].dependsOn("installGitHooks")
    //tasks["assemble"].dependsOn("installGitHooks")
}

//tasks.getByPath(":app:preBuild").dependsOn "installGitHooks"

/*
tasks.getByPath(":app:preBuild").dependsOn(tasks.getByPath("installGitHook"))
tasks.getByPath(":app:clean").dependsOn(tasks.getByPath("installGitHook"))
tasks.getByPath(":app:assemble").dependsOn(tasks.getByPath("installGitHook"))
*/
