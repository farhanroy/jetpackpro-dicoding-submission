package github.learn.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import github.learn.core.data.source.local.dao.MovieDao
import github.learn.core.data.source.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}