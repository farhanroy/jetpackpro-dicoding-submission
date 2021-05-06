package github.learn.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TrendingResponse (

    @SerializedName("page") var page : Int,
    @SerializedName("results") var results : List<Results>,
    @SerializedName("total_pages") var totalPages : Int,
    @SerializedName("total_results") var totalResults : Int

)

data class Results (

    @SerializedName("backdrop_path") var backdropPath : String,
    @SerializedName("first_air_date") var firstAirDate : String,
    @SerializedName("genre_ids") var genreIds : List<Int>,
    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String,
    @SerializedName("origin_country") var originCountry : List<String>,
    @SerializedName("original_language") var originalLanguage : String,
    @SerializedName("original_name") var originalName : String,
    @SerializedName("overview") var overview : String,
    @SerializedName("poster_path") var posterPath : String,
    @SerializedName("vote_average") var voteAverage : Double,
    @SerializedName("vote_count") var voteCount : Int,
    @SerializedName("popularity") var popularity : Double,
    @SerializedName("media_type") var mediaType : String

)