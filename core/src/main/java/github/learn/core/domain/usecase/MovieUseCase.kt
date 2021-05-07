package github.learn.core.domain.usecase

import github.learn.core.data.Resource
import github.learn.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getTrendingMovie(): Flow<Resource<List<Movie>>>
}