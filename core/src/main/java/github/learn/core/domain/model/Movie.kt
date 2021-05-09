package github.learn.core.domain.model

data class Movie(
    val overview : String,
    val original_title : String,
    val poster_path : String,
    val video : Boolean,
    val vote_average : Double,
    val id : Int,
    val vote_count : Int,
    val release_date : String,
    val title : String,
    val adult : Boolean,
    val backdrop_path : String,
    val original_language : String,
    val popularity : Double,
    val media_type : String,
    val isFavorite: Boolean
)