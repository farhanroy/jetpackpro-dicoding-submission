package github.learn.movie.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TrendingMovieResponse (

    @SerializedName("page") var page : Int,
    @SerializedName("results") var results : List<MovieItemResponse>,
    @SerializedName("total_pages") var totalPages : Int,
    @SerializedName("total_results") var totalResults : Int

)