plugins {
    kotlin("multiplatform")
}

kotlin {
    macosX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(Dependencies.Coroutines.Core.Common)
            }
        }

        val macosX64Main by getting {
            dependencies {
                implementation(Dependencies.Coroutines.Core.Native)
            }
        }
    }
}