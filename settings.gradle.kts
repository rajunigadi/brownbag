dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "Brownbag"
// groovy
/*include ':app'*/

// kotlin dsl
include(":app")
include(":feature1")
include(":feature2")
