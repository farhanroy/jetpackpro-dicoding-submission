package github.learn.movie.data

import androidx.lifecycle.LiveData
import github.learn.movie.data.source.local.entity.DetailEntity
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.data.source.local.entity.TvShowEntity

interface MovieCatalogueDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getDetailMovie(movieId: String): LiveData<DetailEntity>
    fun getTvShows(): LiveData<List<TvShowEntity>>
    fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity>
}