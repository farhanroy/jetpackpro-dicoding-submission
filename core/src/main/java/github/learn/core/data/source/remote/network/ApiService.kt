package github.learn.core.data.source.remote.network

import github.learn.core.BuildConfig
import github.learn.core.data.source.remote.response.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovie(@Query("api_key") apiKey: String? = BuildConfig.API_KEY): TrendingResponse

    @GET("trending/tv/day")
    suspend fun getTrendingTv(@Query("api_key") apiKey: String? = BuildConfig.API_KEY): TrendingResponse
}