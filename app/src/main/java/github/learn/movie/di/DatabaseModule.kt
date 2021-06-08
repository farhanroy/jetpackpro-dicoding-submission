package github.learn.movie.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import github.learn.movie.data.source.local.AppDatabase
import github.learn.movie.data.source.local.dao.MovieDao
import github.learn.movie.data.source.local.dao.TvShowDao
import github.learn.movie.utils.Constants
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            Constants.DB_NAME
        ).build()
    }

    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao {
        return database.movieDao()
    }

    @Provides
    fun provideTvShowDao(database: AppDatabase): TvShowDao {
        return database.tvShowDao()
    }
}