package github.learn.movie.ui.favorite.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.MovieEntity

class MovieFavoriteViewModel @ViewModelInject constructor(private val repository: MovieCatalogRepository) : ViewModel() {
    fun getFavMovies() = repository.getFavoriteMovies()

    fun setFavMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFav
        repository.setFavoriteMovie(movieEntity, newState)
    }
}