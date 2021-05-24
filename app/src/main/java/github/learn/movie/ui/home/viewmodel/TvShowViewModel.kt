package github.learn.movie.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.utils.DataDummy

class TvShowViewModel: ViewModel() {
    fun getTvShow() : List<TvShowEntity> = DataDummy.generateDummyTvShows()
}

