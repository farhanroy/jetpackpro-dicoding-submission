package github.learn.core.domain.repository

import github.learn.core.data.Resource
import github.learn.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getTrendingMovie(): Flow<Resource<List<Movie>>>
}