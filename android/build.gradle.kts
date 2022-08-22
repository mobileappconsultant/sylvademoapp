plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
    kotlin(Plugins.kapt)
    id(Plugins.parcelize)
    id(Plugins.hilt)
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.sylval.demo.android"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
        resources.excludes.add("META-INF/*")
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Kotlin.core)
    implementation(Compose.ui)
    implementation(Compose.uiTooling)
    implementation(Compose.livedata)
    implementation(Compose.foundation)
    implementation(Compose.material)
    implementation(Compose.materialIconsCore)
    implementation(Compose.materialIconExtended)
    implementation("com.sinaukoding:cccp:1.0.0")
    implementation(Compose.accompanistPager)
    implementation(Compose.accompanistPagerIndicator)
    androidTestImplementation(Compose.composeUiTest)
    implementation(Compose.navigation)
    implementation(Compose.constraintLayout)
    implementation(Compose.coil)
//    implementation(Compose.countryPicker)

    implementation(Timber.library)
    implementation(Navigation.navigation)
    implementation(Navigation.navigationUI)

    implementation(Kotlin.coroutines)
    implementation(Kotlin.coroutinesCore)
    implementation(Kotlin.coroutineReactive)

    testImplementation(Test.coreTesting)
    testImplementation(Test.coroutineTest)
    testImplementation(Test.turbine)
    testImplementation(Test.mockk)
    testImplementation(Test.extJUnit)
    testImplementation(Test.espressoCore)
    testImplementation(Test.junit)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltAndroidCompiler)
    kapt(Hilt.hiltCompiler)
    implementation(Hilt.hiltNavigation)
    implementation(Ktor.android)

    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.security:security-crypto-ktx:1.1.0-alpha03")
}
