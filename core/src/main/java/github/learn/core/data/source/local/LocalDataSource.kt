package github.learn.core.data.source.local

import github.learn.core.data.source.local.dao.MovieDao
import github.learn.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val tourismDao: MovieDao) {

    fun getAllMovie(): Flow<List<MovieEntity>> = tourismDao.getAllMovie()

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = tourismDao.getFavoriteMovie()

    suspend fun insertMovie(tourismList: List<MovieEntity>) = tourismDao.insertMovie(tourismList)

    fun setFavoriteMovie(tourism: MovieEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteMovie(tourism)
    }
}