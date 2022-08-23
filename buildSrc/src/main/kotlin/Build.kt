object Build {
    private const val gradleBuildTools = "7.2.1"

    const val buildTools = "com.android.tools.build:gradle:$gradleBuildTools"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"
    const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:${SQLDelight.sqlDelightVersion}"
    const val ktlintGradlePlugin = "org.jlleitschuh.gradle:ktlint-gradle:10.1.0"
}
