package com.abhishek.openinapp.data.network.apiservice

import com.abhishek.openinapp.data.network.apiresponse.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface DataApi {

    @GET("api/v1/dashboardNew/")
    fun getData(
        @Header("Authorization") Authorization : String
    ) : Call<ApiResponse>


}