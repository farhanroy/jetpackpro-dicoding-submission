package github.learn.core.utils

import github.learn.core.data.source.local.entity.MovieEntity
import github.learn.core.data.source.remote.response.MovieItemResponse
import github.learn.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieItemResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                popularity = it.popularity,
                overview = it.overview,
                adult = it.adult,
                backdrop_path = it.backdrop_path,
                media_type = it.media_type,
                original_language = it.original_language,
                original_title = it.original_title,
                poster_path = it.poster_path,
                release_date = it.release_date,
                video = it.video,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                popularity = it.popularity,
                overview = it.overview,
                adult = it.adult,
                backdrop_path = it.backdrop_path,
                media_type = it.media_type,
                original_language = it.original_language,
                original_title = it.original_title,
                poster_path = it.poster_path,
                release_date = it.release_date,
                video = it.video,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                isFavorite = it.isFavorite
            )
        }

}