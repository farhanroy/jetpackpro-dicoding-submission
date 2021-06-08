package github.learn.movie.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import github.learn.movie.data.source.local.dao.MovieDao
import github.learn.movie.data.source.local.dao.TvShowDao
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.utils.Constants
import github.learn.movie.utils.Constants.MOVIE_TABLE
import github.learn.movie.utils.Constants.TV_SHOW_TABLE
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val movieDao: MovieDao,
    private val tvShowDao: TvShowDao
) {
    fun getAllMovies(sort: String): DataSource.Factory<Int, MovieEntity> = movieDao.getMovies(Constants.getSortedQuery(sort, MOVIE_TABLE))

    fun getMovieById(id: Int): LiveData<MovieEntity> = movieDao.getMovieById(id)

    fun getFavMovies(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavMovies()

    fun getAllTvShows(sort: String): DataSource.Factory<Int, TvShowEntity> = tvShowDao.getTvShows(Constants.getSortedQuery(sort, TV_SHOW_TABLE))

    fun getTvShowById(id: Int): LiveData<TvShowEntity> = tvShowDao.getTvShowById(id)

    fun getFavTvShows(): DataSource.Factory<Int, TvShowEntity> = tvShowDao.getFavTvShows()

    fun insertMovies(movies: List<MovieEntity>) = movieDao.insertMovies(movies)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFav = newState
        movieDao.updateMovie(movie)
    }

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFav = newState
        movieDao.updateMovie(movie)
    }

    fun insertTvShows(tvShows: List<TvShowEntity>) = tvShowDao.insertTvShows(tvShows)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFav = newState
        tvShowDao.updateTvShow(tvShow)
    }

    fun updateTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFav = newState
        tvShowDao.updateTvShow(tvShow)
    }
}