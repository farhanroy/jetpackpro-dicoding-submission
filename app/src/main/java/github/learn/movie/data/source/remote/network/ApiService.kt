package github.learn.movie.data.source.remote.network

import github.learn.movie.BuildConfig
import github.learn.movie.data.source.remote.response.TrendingMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovie(@Query("api_key") apiKey: String? = BuildConfig.API_KEY): TrendingMovieResponse

}