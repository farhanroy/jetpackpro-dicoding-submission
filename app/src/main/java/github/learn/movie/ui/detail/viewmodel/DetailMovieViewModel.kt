package github.learn.movie.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import github.learn.movie.data.source.local.entity.MovieEntity

class DetailMovieViewModel: ViewModel() {

    private lateinit var movie: MovieEntity

    fun getMovie(): MovieEntity = this.movie

    fun setMovie(movie: MovieEntity) {
        this.movie = movie
    }
}