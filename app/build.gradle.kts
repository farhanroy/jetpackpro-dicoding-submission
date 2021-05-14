plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.daggerHilt)
    kotlin(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.buildTools)

    defaultConfig {
        applicationId(AndroidSdk.applicationId)
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}


dependencies {

    implementation(project(":core"))

    implementation(Libraries.kotlinStdLib)

    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.androidLegacy)

    // Lifecycle
    implementation(Libraries.lifecycle)
    implementation(Libraries.viewModel)

    // Room
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)

    // Navigation
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUI)

    // Hilt
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltAndroidCompiler)

    implementation(Libraries.hiltViewModel)
    kapt(Libraries.hiltCompiler)

    // Glide
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}