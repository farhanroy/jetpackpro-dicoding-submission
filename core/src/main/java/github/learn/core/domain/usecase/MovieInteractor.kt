package github.learn.core.domain.usecase

import github.learn.core.data.Resource
import github.learn.core.domain.model.Movie
import github.learn.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase {
    override fun getTrendingMovie(): Flow<Resource<List<Movie>>> = movieRepository.getTrendingMovie()
}