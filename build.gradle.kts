plugins {
    id("com.android.application") version "8.2.2" apply true
    id("org.jetbrains.kotlin.android") version "1.9.22" apply true
}

android {
    namespace = "com.example.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDirs("")
            kotlin.srcDirs("")
            res.srcDirs(".")
        }
    }
}

