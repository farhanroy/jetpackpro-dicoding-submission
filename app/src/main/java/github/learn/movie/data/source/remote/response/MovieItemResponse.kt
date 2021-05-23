package github.learn.movie.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieItemResponse (

    @SerializedName("overview") val overview : String,
    @SerializedName("original_title") val original_title : String,
    @SerializedName("poster_path") val poster_path : String,
    @SerializedName("video") val video : Boolean,
    @SerializedName("vote_average") val vote_average : Double,
    @SerializedName("id") val id : Int,
    @SerializedName("vote_count") val vote_count : Int,
    @SerializedName("release_date") val release_date : String,
    @SerializedName("title") val title : String,
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("backdrop_path") val backdrop_path : String,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("media_type") val media_type : String

)