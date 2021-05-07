package github.learn.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import github.learn.core.data.MovieRepository
import github.learn.core.domain.repository.IMovieRepository

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: MovieRepository): IMovieRepository

}