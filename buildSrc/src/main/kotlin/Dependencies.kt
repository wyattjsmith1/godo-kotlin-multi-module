object Versions {
    const val Coroutines = "1.3.2-1.3.60"
    const val GodotKotlin = "0.1.0-3.2"
    const val Gradle = "6.2.2"
    const val Kodein = "6.5.0"
    const val Kotlin = "1.3.61"
}

object Dependencies {
    object Coroutines {
        object Core {
            const val Common = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.Coroutines}"
            const val Native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.Coroutines}"
        }
    }

    object Kodein {
        const val Core = "org.kodein.di:kodein-di-core:${Versions.Kodein}"
        const val Erased = "org.kodein.di:kodein-di-erased:${Versions.Kodein}"
        const val Conf = "org.kodein.di:kodein-di-conf:${Versions.Kodein}"
    }

    object StdLib {
        const val Common = "stdlib-common"
    }
}