package github.learn.movie.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import github.learn.core.domain.usecase.MovieUseCase

class HomeViewModel @ViewModelInject constructor(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getTrendingMovie().asLiveData()
}