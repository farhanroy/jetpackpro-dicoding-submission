package github.learn.movie.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import github.learn.movie.R
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.databinding.ActivityDetailTvBinding
import github.learn.movie.ui.detail.viewmodel.DetailTvViewModel
import github.learn.movie.utils.getParcel
import github.learn.movie.utils.putParcel

class DetailTvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvBinding

    private val viewModel: DetailTvViewModel by viewModels()

    private var data: TvShowEntity? = null

    companion object {
        fun newIntent(context: Context, tv: TvShowEntity? = null): Intent {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.share -> {
                shareTv()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initToolbar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Detail TV"
        }
    }

    private fun initData() {
        data = intent.getParcel(this.getString(R.string.extra_tv))
        data?.let { viewModel.setTv(it) }
    }

    private fun initView() {
        val tvShow = viewModel.getTv()

        binding.tvTitle.text = tvShow.name
        binding.tvDescription.text = tvShow.name
        binding.tvRelease.text = tvShow.name
        Glide.with(this).load(tvShow.posterPath).into(binding.ivPoster)
    }

    private fun shareTv() {
        val tvTitle = data?.name
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, tvTitle)
            type = "text/plain"
        }
        startActivity(sendIntent)
    }
}