package github.learn.movie.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import github.learn.movie.model.TV

class DetailTvViewModel: ViewModel() {

    private lateinit var tv: TV

    fun getTv(): TV = this.tv

    fun setTv(tv: TV) {
        this.tv = tv
    }
}

