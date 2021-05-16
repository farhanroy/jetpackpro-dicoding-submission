package github.learn.movie.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import github.learn.movie.model.TV
import github.learn.movie.utils.DataDummy

class TvShowViewModel: ViewModel() {
    fun getTvShow() : List<TV> = DataDummy.generateDummyTvShows()
}

