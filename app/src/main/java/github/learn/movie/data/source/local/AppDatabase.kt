package github.learn.movie.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import github.learn.movie.data.source.local.dao.MovieDao
import github.learn.movie.data.source.local.dao.TvShowDao
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.data.source.local.entity.TvShowEntity

@Database(
    entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
}