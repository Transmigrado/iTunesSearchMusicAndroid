package com.blueprint.itunes.datasource.api

import com.blueprint.itunes.model.TrackSearchResponse
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit




class ApiClient {

    companion object {

        private var servicesApiInterface: ServicesApiInterface? = null

        fun getApiClient(): ServicesApiInterface {

            if (servicesApiInterface == null) {


                val retrofit = Retrofit.Builder()
                    .baseUrl("https://itunes.apple.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


                servicesApiInterface = retrofit.create(ServicesApiInterface::class.java!!)

            }
            return servicesApiInterface as ServicesApiInterface
        }

    }


    interface ServicesApiInterface {
        @GET("/search?mediaType=music&limit=20")
        fun tracks(@Query("term") music:String, @Query("offset") offset:Int): Call<TrackSearchResponse>
    }



}