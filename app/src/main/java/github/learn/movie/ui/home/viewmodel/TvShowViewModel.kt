package github.learn.movie.ui.home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import github.learn.movie.data.MovieCatalogRepository

class TvShowViewModel @ViewModelInject constructor(
    private val repository: MovieCatalogRepository
): ViewModel() {
    fun getTvShow(sort: String) = repository.getTvShows(sort)
}

