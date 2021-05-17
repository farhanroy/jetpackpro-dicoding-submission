package github.learn.movie.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.databinding.ActivitySplashBinding
import github.learn.movie.ui.home.HomeActivity
import kotlinx.coroutines.*

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toHome()
    }

    override fun onStop() {
        super.onStop()
        activityScope.cancel()
    }

    /*
    * Navigate to home screen using delay 3 second
    */
    private fun toHome() {
        activityScope.launch {
            delay(3000)

            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}