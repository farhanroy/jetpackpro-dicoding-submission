package github.learn.movie.ui.detail.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.TvShowEntity

class DetailTvViewModel @ViewModelInject constructor(
    private val repository: MovieCatalogRepository
): ViewModel() {

    fun getTv(id: String) = repository.getDetailTvShow(id)
}

