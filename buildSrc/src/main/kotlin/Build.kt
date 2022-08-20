object Build {
    private const val gradleBuildTools = "7.2.1"
    private const val googleServicesVersion = "4.3.10"
    private const val navigationVersion = "2.3.5"
    const val deteKtVersion = "1.16.0"

    const val buildTools = "com.android.tools.build:gradle:$gradleBuildTools"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"
    const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:${SQLDelight.sqlDelightVersion}"
    const val googleServicesPlugin = "com.google.gms:google-services:$googleServicesVersion"
    const val navigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
    const val detektPlugin = "io.gitlab.arturbosch.detekt"
}
