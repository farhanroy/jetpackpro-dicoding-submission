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

    @ColumnInfo(name = "overview")
    val overview : String,

    @ColumnInfo(name = "original_title")
    val original_title : String,

    @ColumnInfo(name = "poster_path")
    val poster_path : String,

    @ColumnInfo(name = "video")
    val video : Boolean,
    @ColumnInfo(name = "vote_average")
    val vote_average : Double,

    @ColumnInfo(name = "vote_count")
    val vote_count : Int,

    @ColumnInfo(name = "release_date")
    val release_date : String,

    @ColumnInfo(name = "title")
    val title : String,

    @ColumnInfo(name = "adult")
    val adult : Boolean,

    @ColumnInfo(name = "backdrop_path")
    val backdrop_path : String,

    @ColumnInfo(name = "original_language")
    val original_language : String,

    @ColumnInfo(name = "popularity")
    val popularity : Double,

    @ColumnInfo(name = "media_type")
    val media_type : String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)