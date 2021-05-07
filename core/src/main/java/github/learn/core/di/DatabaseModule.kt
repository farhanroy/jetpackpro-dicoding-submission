package github.learn.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import github.learn.core.data.source.local.dao.MovieDao
import github.learn.core.data.source.local.room.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "MovieCatalog.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao = database.movieDao()
}