package github.learn.core.utils

import github.learn.core.data.source.local.entity.MovieEntity
import github.learn.core.data.source.remote.response.Results
import github.learn.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<Results>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                name = it.name,
                backdropPath = it.backdropPath,
                mediaType = it.mediaType,
                originalLanguage = it.originalLanguage,
                originalName = it.originalName,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
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
                name = it.name,
                backdropPath = it.backdropPath,
                mediaType = it.mediaType,
                originalLanguage = it.originalLanguage,
                originalName = it.originalName,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        name = input.name,
        backdropPath = input.backdropPath,
        mediaType = input.mediaType,
        originalLanguage = input.originalLanguage,
        originalName = input.originalName,
        overview = input.overview,
        popularity = input.popularity,
        posterPath = input.posterPath,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
        isFavorite = input.isFavorite
    )
}