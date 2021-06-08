package github.learn.movie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.LocalDataSource
import github.learn.movie.data.source.local.dao.MovieDao
import github.learn.movie.data.source.local.dao.TvShowDao
import github.learn.movie.data.source.remote.RemoteDataSource
import github.learn.movie.data.source.remote.network.ApiService
import github.learn.movie.utils.AppExecutors
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieCatalogRepository(apiService: ApiService, movieDao: MovieDao, tvShowDao: TvShowDao) = MovieCatalogRepository(
        RemoteDataSource(apiService),
        LocalDataSource(movieDao, tvShowDao),
        AppExecutors()
    )
}