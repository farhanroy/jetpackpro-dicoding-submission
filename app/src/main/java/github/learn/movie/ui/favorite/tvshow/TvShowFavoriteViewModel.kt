package github.learn.movie.ui.favorite.tvshow

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.TvShowEntity

class TvShowFavoriteViewModel @ViewModelInject constructor(private val repository: MovieCatalogRepository) : ViewModel() {
    fun getFavTvShows() = repository.getFavoriteTvShows()

    fun setFavTvShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFav
        repository.setFavoriteTvShow(tvShowEntity, newState)
    }
}