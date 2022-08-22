buildscript {
    apply(from = "githooks.gradle")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
    dependencies {
        classpath(Build.buildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.hiltGradlePlugin)
        classpath(Build.sqlDelightGradlePlugin)
        classpath(Build.ktlintGradlePlugin)
    }
}
subprojects {
    apply(plugin = Plugins.ktlint)

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        disabledRules.set(kotlin.collections.listOf("import-ordering", "no-wildcard-imports"))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}