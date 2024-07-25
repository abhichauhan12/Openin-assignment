package com.abhishek.openinapp.domian.repository

import android.util.Log
import com.abhishek.openinapp.data.network.FetchStatus
import com.abhishek.openinapp.data.network.apiresponse.ApiResponse
import com.abhishek.openinapp.data.network.apiservice.DataApi
import com.abhishek.openinapp.utils.TOKEN
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.abhishek.openinapp.domian.core.Result
import javax.inject.Inject


class NetworkRepository @Inject constructor(
    private val dataApi: DataApi
) {

    suspend fun getData() :Result<ApiResponse>{
        return withContext(Dispatchers.IO){
            try {

                val response = dataApi
                    .getData(TOKEN)
                    .execute()

                val responseBody =response.body()
                Log.d("API Success", "Response: $responseBody")

                if (response.isSuccessful && responseBody != null){
                    Result(FetchStatus.FETCHED, responseBody)
                }else if (response.code() == 401) {
                    // Handling 404 specifically
                    Log.d("API Error", "UNAUTHORIZED")
                    Result(FetchStatus.FAILURE("UNAUTHORIZED"), null)
                } else
                    Result(FetchStatus.FAILURE("Failed to fetch data: ${response.code()}"), null)
            }catch (e: Exception){
                Log.d("API Error", "Failed to fetch data: ${e.message}")
                Result(FetchStatus.FAILURE(e.message), null)
            }
        }
    }



}