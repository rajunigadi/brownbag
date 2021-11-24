import Dependencies.commonIntegrationTest

plugins {
    id(Plugins.COMMON)
}

dependencies {
    implementation(Dependencies.Google.MATERIAL)
    commonIntegrationTest()
}