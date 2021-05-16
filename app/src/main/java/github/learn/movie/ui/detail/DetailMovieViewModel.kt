package github.learn.movie.ui.detail

import androidx.lifecycle.ViewModel
import github.learn.movie.model.Movie

class DetailMovieViewModel: ViewModel() {

    private lateinit var movie: Movie

    fun getMovie(): Movie = this.movie

    fun setMovie(movie: Movie) {
        this.movie = movie
    }
}