package github.learn.movie.ui.detail

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.databinding.ActivityDetailTvBinding
import github.learn.movie.ui.detail.viewmodel.DetailTvViewModel
import github.learn.movie.utils.Constants
import github.learn.movie.utils.Status
import kotlin.math.abs

@AndroidEntryPoint
class DetailTvActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

    private lateinit var binding: ActivityDetailTvBinding

    private val viewModel: DetailTvViewModel by viewModels()

    private var dataId: Int? = null

    private val percentageToShowImage = 20
    private var mMaxScrollSize = 0
    private var mIsImageHidden = false

    companion object {
        fun newIntent(context: Context, id: Int? = null): Intent {
            return Intent(context, DetailTvActivity::class.java).apply {
                putExtra(context.getString(R.string.extra_tv), id)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        dataId = intent.getIntExtra(this.getString(R.string.extra_tv), 0)
        setContentView(binding.root)

        supportActionBar?.hide()

        initView()

        viewModel.setTvShow(dataId!!)
        initState()
        observeLiveData()
    }

    private fun initView(){
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.share -> {
                    shareTvShow()
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }

        binding.appbar.addOnOffsetChangedListener(this)

        binding.fabFavorite.setOnClickListener {
            viewModel.setFavoriteTvShow()
        }
    }

    private fun observeLiveData() {
        viewModel.getDetailTvShow().observe(this) { detail ->
            when (detail.status) {
                Status.LOADING -> showProgressBar(true)
                Status.SUCCESS -> {
                    if (detail.data != null) {
                        showProgressBar(false)
                        populateDataDetail(detail.data)
                    }
                }
                Status.ERROR -> {
                    showProgressBar(false)
                    Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }

    private fun initState() {
        viewModel.getDetailTvShow().observe(this) { movie ->
            when (movie.status) {
                Status.LOADING -> showProgressBar(true)
                Status.SUCCESS -> {
                    if (movie.data != null) {
                        showProgressBar(false)
                        val state = movie.data.isFav
                        setFavoriteState(state)
                    }
                }
                Status.ERROR -> {
                    showProgressBar(false)
                    Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun populateDataDetail(data: TvShowEntity) {

        val genreDurationText = resources.getString(R.string.genre_duration_text)

        binding.tvDetailGenreDuration.text = genreDurationText
        binding.collapsing.title = data.name
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


    private fun shareTvShow() {
        val movieTitle = dataId
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
        binding.fabFavorite.isInvisible = state
    }

    private fun setFavoriteState(state: Boolean) {
        val fab = binding.fabFavorite
        if (state) {
            fab.setImageResource(R.drawable.ic_favorite_white_24)
        } else {
            fab.setImageResource(R.drawable.ic_favorite_border_white_24)
        }
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