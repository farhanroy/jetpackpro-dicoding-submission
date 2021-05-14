package github.learn.movie.model

data class TV(
    var id: String,
    var title: String,
    var description: String,
    var genre: String,
    var releaseYear: String,
    var imgPoster: Int,
    var imgBackground: Int
)