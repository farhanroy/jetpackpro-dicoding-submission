package github.learn.movie.ui.detail.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.utils.Resource

class DetailTvViewModel @ViewModelInject constructor(
    private val repository: MovieCatalogRepository
): ViewModel() {

    private lateinit var detailTvShow: LiveData<Resource<TvShowEntity>>

    fun setTvShow(id: Int) {
        detailTvShow = repository.getDetailTvShow(id)
    }

    fun setFavoriteTvShow() {
        val resource = detailTvShow.value
        if (resource?.data != null) {
            val newState = !resource.data.isFav
            repository.setFavoriteTvShow(resource.data, newState)
        }
    }

    fun getDetailTvShow() = detailTvShow

}

