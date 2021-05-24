package github.learn.movie.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import github.learn.movie.data.source.local.entity.TvShowEntity

class DetailTvViewModel: ViewModel() {

    private lateinit var tv: TvShowEntity

    fun getTv(): TvShowEntity = this.tv

    fun setTv(tv: TvShowEntity) {
        this.tv = tv
    }
}

