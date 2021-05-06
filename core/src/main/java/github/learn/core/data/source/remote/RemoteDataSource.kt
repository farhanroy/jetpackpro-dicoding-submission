package github.learn.core.data.source.remote

import android.util.Log
import github.learn.core.data.source.remote.network.ApiResponse
import github.learn.core.data.source.remote.network.ApiService
import github.learn.core.data.source.remote.response.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getTrendingMovie(): Flow<ApiResponse<List<Results>>> {
        return flow {
            try {
                val response = apiService.getTrendingMovie()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}