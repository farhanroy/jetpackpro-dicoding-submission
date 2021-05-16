package github.learn.movie.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import github.learn.movie.R
import github.learn.movie.databinding.ActivityDetailTvBinding
import github.learn.movie.model.Movie
import github.learn.movie.model.TV
import github.learn.movie.utils.getParcel
import github.learn.movie.utils.putParcel

class DetailTvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvBinding

    private val viewModel: DetailTvViewModel by viewModels()

    private var data: TV? = null

    companion object {
        fun newIntent(context: Context, tv: TV? = null): Intent {
            return Intent(context, DetailTvActivity::class.java).apply {
                putParcel(context.getString(R.string.extra_tv), tv)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
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
        data = intent.getParcel(this.getString(R.string.extra_tv))
        data?.let { viewModel.setTv(it) }
    }

    private fun initView() {
        val movie = viewModel.getTv()

        binding.tvTitle.text = movie.title
        binding.tvDescription.text = movie.description
        binding.tvRelease.text = movie.releaseYear
        Glide.with(this).load(movie.imgPoster).into(binding.ivPoster)
    }
}