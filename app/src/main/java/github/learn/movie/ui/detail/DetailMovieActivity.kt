package github.learn.movie.ui.detail

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.observe
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.R
import github.learn.movie.data.source.local.entity.DetailEntity
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.databinding.ActivityDetailMovieBinding
import github.learn.movie.ui.detail.viewmodel.DetailMovieViewModel
import github.learn.movie.utils.Constants
import github.learn.movie.utils.getParcel
import github.learn.movie.utils.putParcel
import kotlin.math.abs

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

    private lateinit var binding: ActivityDetailMovieBinding

    private val viewModel: DetailMovieViewModel by viewModels()

    private var data: MovieEntity? = null

    private val percentageToShowImage = 20
    private var mMaxScrollSize = 0
    private var mIsImageHidden = false

    companion object {
        fun newIntent(context: Context, movie: MovieEntity? = null): Intent {
            return Intent(context, DetailMovieActivity::class.java).apply {
                putParcel(context.getString(R.string.extra_movie), movie)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        data = intent.getParcel(this.getString(R.string.extra_movie))
        setContentView(binding.root)

        supportActionBar?.hide()

        showProgressBar(true)

        initToolbar()
        observeLiveData()
    }

    private fun initToolbar(){
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.share -> {
                    shareMovie()
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }

        binding.appbar.addOnOffsetChangedListener(this)
    }

    private fun observeLiveData() {
        viewModel.getMovie((data?.id).toString()).observe(this) {
            populateDataDetail(it)
        }
    }

    private fun populateDataDetail(data: DetailEntity) {
        val genre = data.genres.toString().replace("[", "").replace("]", "")

        val genreDurationText = resources.getString(R.string.genre_duration_text)

        binding.tvDetailGenreDuration.text = genreDurationText
        binding.collapsing.title = data.title
        binding.tvDetailOverview.text = data.overview

        Glide.with(this)
            .asBitmap()
            .load(Constants.IMAGE_URL + data.posterPath)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    binding.ivDetail.setImageBitmap(resource)
                    setColorByPalette(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {

                }
            })

        Glide.with(this)
            .load(Constants.IMAGE_URL + data.backdropPath)
            .into(binding.ivBackdrop)

        binding.ivDetail.tag = data.posterPath
        binding.ivBackdrop.tag = data.backdropPath

        showProgressBar(false)
    }


    private fun shareMovie() {
        val movieTitle = data?.title
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, movieTitle)
            type = "text/plain"
        }
        startActivity(sendIntent)
    }

    private fun showProgressBar(state: Boolean) {
        binding.progressBar.isVisible = state
        binding.appbar.isInvisible = state
        binding.nestedScrollView.isInvisible = state
    }


    private fun setColorByPalette(poster: Bitmap) {
        Palette.from(poster).generate { palette ->
            val defValue = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                resources.getColor(R.color.blue_700, theme)
            } else {
                TODO("VERSION.SDK_INT < M")
            }
            binding.cardDetail.setCardBackgroundColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            binding.collapsing.setContentScrimColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            window.statusBarColor = palette?.getDarkMutedColor(defValue) ?: defValue
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBarLayout!!.totalScrollRange

        val currentScrollPercentage: Int = (abs(verticalOffset) * 100 / mMaxScrollSize)

        if (currentScrollPercentage >= percentageToShowImage) {
            if (!mIsImageHidden) {
                mIsImageHidden = true
            }
        }

        if (currentScrollPercentage < percentageToShowImage) {
            if (mIsImageHidden) {
                mIsImageHidden = false
            }
        }
    }
}