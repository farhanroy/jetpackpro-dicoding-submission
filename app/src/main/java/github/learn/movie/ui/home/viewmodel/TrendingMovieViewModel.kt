package github.learn.movie.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import github.learn.movie.model.Movie
import github.learn.movie.utils.DataDummy

class TrendingMovieViewModel: ViewModel() {
    fun getTrendingMovie() : List<Movie> = DataDummy.generateDummyMovies()
}
