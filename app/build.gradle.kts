plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.daggerHilt)
    id(BuildPlugins.androidExtension)
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
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", App.BASE_URL)
        buildConfigField("String", "API_KEY", App.API_KEY)
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
    implementation("androidx.palette:palette-ktx:1.0.0")
    kapt(Libraries.roomCompiler)

    // Navigation
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUI)

    // Coroutine
    implementation(Libraries.coroutineCore)
    implementation(Libraries.coroutineAndroid)

    // Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverter)
    api(Libraries.loggingInterceptor)

    // Hilt
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltAndroidCompiler)

    implementation(Libraries.hiltViewModel)
    kapt(Libraries.hiltCompiler)

    // Glide
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    implementation(Libraries.testCore)
    implementation("androidx.test.espresso:espresso-idling-resource:3.1.0")

    testImplementation(TestLibraries.junit4)
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.mockito:mockito-core:3.6.0")
    testImplementation ("org.mockito:mockito-inline:3.6.0")
    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    androidTestImplementation(TestLibraries.extJunit)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.testRules)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.espressoContrib)
}