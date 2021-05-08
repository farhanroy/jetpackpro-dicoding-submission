package github.learn.movie.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import github.learn.core.domain.usecase.MovieInteractor
import github.learn.core.domain.usecase.MovieUseCase

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideMovieUseCase(tourismInteractor: MovieInteractor): MovieUseCase

}