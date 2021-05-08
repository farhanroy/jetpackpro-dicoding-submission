plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.daggerHilt)
    kotlin(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.buildTools)

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", App.BASE_URL)
        buildConfigField("String", "API_KEY", App.API_KEY)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)

    // Coroutine
    implementation(Libraries.coroutineCore)
    implementation(Libraries.coroutineAndroid)

    // Hilt
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltAndroidCompiler)

    // Room
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)

    // Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverter)
    api(Libraries.loggingInterceptor)

    testImplementation (TestLibraries.junit4)
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)
}