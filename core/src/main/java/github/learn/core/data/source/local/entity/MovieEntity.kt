package github.learn.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name= "backdrop_path")
    var backdropPath : String,

    @ColumnInfo(name= "name")
    var name : String,

    @ColumnInfo(name= "original_language")
    var originalLanguage : String,

    @ColumnInfo(name= "original_name")
    var originalName : String,

    @ColumnInfo(name= "overview")
    var overview : String,

    @ColumnInfo(name= "poster_path")
    var posterPath : String,

    @ColumnInfo(name= "vote_average")
    var voteAverage : Double,

    @ColumnInfo(name= "vote_count")
    var voteCount : Int,

    @ColumnInfo(name= "popularity")
    var popularity : Double,

    @ColumnInfo(name= "media_type")
    var mediaType : String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)