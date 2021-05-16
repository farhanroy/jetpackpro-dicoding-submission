package github.learn.movie.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.R
import github.learn.movie.databinding.ActivityDetailMovieBinding
import github.learn.movie.model.Movie
import github.learn.movie.utils.getParcel
import github.learn.movie.utils.putParcel

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding

    private val viewModel: DetailMovieViewModel by viewModels()

    private var data: Movie? = null

    companion object {
        fun newIntent(context: Context, movie: Movie? = null): Intent {
            return Intent(context, DetailMovieActivity::class.java).apply {
                putParcel(context.getString(R.string.extra_movie), movie)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolbar()
        initData()
        initView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initData() {
        data = intent.getParcel(this.getString(R.string.extra_movie))
        data?.let { viewModel.setMovie(it) }
    }

    private fun initView() {
        val movie = viewModel.getMovie()

        binding.tvTitle.text = movie.title
        binding.tvDescription.text = movie.description
        binding.tvRelease.text = movie.releaseYear
        Glide.with(this).load(movie.imgPoster).into(binding.ivPoster)
    }
}