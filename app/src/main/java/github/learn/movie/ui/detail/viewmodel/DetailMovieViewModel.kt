package github.learn.movie.ui.detail.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.utils.Resource

class DetailMovieViewModel @ViewModelInject constructor(
    private val repository: MovieCatalogRepository
): ViewModel() {

    private lateinit var detailMovie: LiveData<Resource<MovieEntity>>

    fun setFilm(id: Int) {
        detailMovie = repository.getDetailMovie(id)
    }

    fun setFavoriteMovie() {
        val resource = detailMovie.value
        if (resource?.data != null) {
            val newState = !resource.data.isFav
            repository.setFavoriteMovie(resource.data, newState)
        }
    }
    
    fun getDetailMovie() = detailMovie
}