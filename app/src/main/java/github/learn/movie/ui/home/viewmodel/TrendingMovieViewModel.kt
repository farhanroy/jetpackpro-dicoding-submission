package github.learn.movie.ui.home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import github.learn.movie.data.MovieCatalogRepository

class TrendingMovieViewModel @ViewModelInject constructor(
    private val repository: MovieCatalogRepository
): ViewModel() {
    fun getTrendingMovie(sort: String) = repository.getMovies(sort)
}
