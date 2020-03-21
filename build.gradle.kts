buildscript {
    repositories {
        mavenLocal()
        maven("https://dl.bintray.com/utopia-rise/kotlin-godot")
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}")
    }
}

plugins {
    id("org.jetbrains.kotlin.multiplatform") version Versions.Kotlin
}

allprojects {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://kotlin.bintray.com/kotlinx")
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = Versions.Gradle
}
