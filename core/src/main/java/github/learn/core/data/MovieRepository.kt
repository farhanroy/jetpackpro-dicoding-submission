package github.learn.core.data

import github.learn.core.data.source.local.LocalDataSource
import github.learn.core.data.source.remote.RemoteDataSource
import github.learn.core.data.source.remote.network.ApiResponse
import github.learn.core.data.source.remote.response.Results
import github.learn.core.domain.model.Movie
import github.learn.core.domain.repository.IMovieRepository
import github.learn.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): IMovieRepository {
    override fun getTrendingMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<Results>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                //data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<Results>>> =
                remoteDataSource.getTrendingMovie()

            override suspend fun saveCallResult(data: List<Results>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(tourismList)
            }
        }.asFlow()
}

