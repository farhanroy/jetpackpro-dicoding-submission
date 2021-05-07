package github.learn.core.domain.model


data class Movie(
    var backdropPath : String,
    var firstAirDate : String,
    var genreIds : List<Int>,
    var id : Int,
    var name : String,
    var originCountry : List<String>,
    var originalLanguage : String,
    var originalName : String,
    var overview : String,
    var posterPath : String,
    var voteAverage : Double,
    var voteCount : Int,
    var popularity : Double,
    var mediaType : String,
    var isFavorite: Boolean
)