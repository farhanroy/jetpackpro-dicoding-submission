package github.learn.movie.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.databinding.ActivitySplashBinding
import github.learn.movie.ui.home.HomeActivity

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toHome()
    }

    /*
    * Navigate to home screen using delay 3 second
    */
    private fun toHome() {
        Runnable {
            Thread.sleep(3000)
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        }
    }
}