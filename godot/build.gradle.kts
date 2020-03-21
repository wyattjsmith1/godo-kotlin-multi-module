import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeCompilation
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

val platform: String by project
val armArch: String by project
val iosSigningIdentity: String by project
val buildType: String? by project

buildscript {
    repositories {
        mavenLocal()
//        maven("https://dl.bintray.com/utopia-rise/kotlin-godot")
        jcenter()
    }
    dependencies {
        classpath("org.godotengine.kotlin:godot-gradle-plugin:${Versions.GodotKotlin}")
    }
}

plugins {
    kotlin("multiplatform")
}

apply(plugin = "godot-gradle-plugin")

repositories {
    mavenLocal()
    maven("https://dl.bintray.com/utopia-rise/kotlin-godot")
    maven("https://dl.bintray.com/utopia-rise/kotlinx")

    //Here we exclude jetbrains coroutines and atomicfu because they do not provide the ones for android platform
    //so we exclude them so that those dependencies are downloaded from our bintray, where we provide android dependencies
    jcenter {
        content {
            excludeModule("org.jetbrains.kotlinx", "kotlinx-coroutines-core-native")
            excludeModule("org.jetbrains.kotlinx", "atomicfu-native")
        }
    }
    mavenCentral {
        content {
            excludeModule("org.jetbrains.kotlinx", "kotlinx-coroutines-core-native")
            excludeModule("org.jetbrains.kotlinx", "atomicfu-native")
        }
    }
}

configure<org.godotengine.kotlin.gradleplugin.KotlinGodotPluginExtension> {
    this.releaseType = when (buildType?.toLowerCase()) {
        "release" -> NativeBuildType.RELEASE
        else -> NativeBuildType.DEBUG
    }
    this.godotProjectPath = "${project.rootDir.absolutePath}/.."
    println(this.godotProjectPath)
    this.libraryPath = "gdnativelibrary.gdnlib"
    this.configureTargetAction = ::configureTargetAction
}

kotlin {
    sourceSets {
        sourceSets.create("macosMain")
        sourceSets.create("linuxMain")
        sourceSets.create("windowsMain")
        sourceSets.create("androidArm64Main")
        sourceSets.create("androidX64Main")
        sourceSets.create("iosArm64Main")
        sourceSets.create("iosX64Main")
        configure(
            listOf(
                sourceSets["macosMain"],
                sourceSets["linuxMain"],
                sourceSets["windowsMain"],
                sourceSets["androidArm64Main"],
                sourceSets["androidX64Main"],
                sourceSets["iosArm64Main"],
                sourceSets["iosX64Main"]
            )
        ) {
            this.kotlin.srcDir("src/main/kotlin")
        }
    }

    if (project.hasProperty("platform")) {
        when (platform) {
            "windows" -> listOf(targetFromPreset(presets["godotMingwX64"], "windows"))
            "linux" -> listOf(targetFromPreset(presets["godotLinuxX64"], "linux"))
            "macos" -> listOf(targetFromPreset(presets["godotMacosX64"], "macos"))
            "android" -> if (project.hasProperty("armArch")) {
                when (armArch) {
                    "X64" -> listOf(targetFromPreset(presets["godotAndroidNativeX64"], "androidX64"))
                    "arm64" -> listOf(targetFromPreset(presets["godotAndroidNativeArm64"], "androidArm64"))
                    else -> listOf(targetFromPreset(presets["godotAndroidNativeArm64"], "androidArm64"))
                }
            } else listOf(targetFromPreset(presets["godotAndroidNativeArm64"], "androidArm64"))
            "ios" -> if (project.hasProperty("armArch")) {
                when (armArch) {
                    "arm64" -> listOf(targetFromPreset(presets["godotIosArm64"], "iosArm64"))
                    "X64" -> listOf(targetFromPreset(presets["godotIosX64"], "iosX64"))
                    else -> listOf(targetFromPreset(presets["godotIosArm64"], "iosArm64"))
                }
            } else listOf(targetFromPreset(presets["godotIosArm64"], "iosArm64"))
            else -> listOf(targetFromPreset(presets["godotLinuxX64"], "linux"))
        }
    } else {
        listOf(
            targetFromPreset(presets["godotLinuxX64"], "linux"),
            targetFromPreset(presets["godotMacosX64"], "macos"),
            targetFromPreset(presets["godotMingwX64"], "windows"),
            targetFromPreset(presets["godotAndroidNativeArm64"], "androidArm64"),
            targetFromPreset(presets["godotAndroidNativeX64"], "androidX64"),
            targetFromPreset(presets["godotIosArm64"], "iosArm64"),
            targetFromPreset(presets["godotIosX64"], "iosX64")
        )
    }
}

fun configureTargetAction(kotlinTarget: @ParameterName(name = "target") KotlinTarget) {
    kotlinTarget.compilations.getByName("main") {
        if (this is KotlinNativeCompilation) {
            println("Configuring target ${target.name}")
            target.compilations.all {
                dependencies {
                    implementation("org.godotengine.kotlin:godot-library:0.1.1-3.2") // or implementation("org.godotengine.kotlin:godot-library-extension:1.0.0") if you want coroutines like yield
                    implementation("org.godotengine.kotlin:annotations:0.1.1-3.2")
                    implementation(project(":util"))
                }
            }
        } else {
            System.err.println("Not a native target! TargetName: ${target.name}")
        }
    }
}
