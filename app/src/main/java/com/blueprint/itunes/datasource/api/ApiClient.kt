package com.blueprint.itunes.datasource.api

import com.blueprint.itunes.model.TrackSearchResponse
import com.squareup.okhttp.OkHttpClient
import retrofit.Callback
import retrofit.RestAdapter
import retrofit.client.OkClient
import retrofit.http.GET
import retrofit.http.Query

class ApiClient {

    companion object {

        private var servicesApiInterface: ServicesApiInterface? = null

        fun getApiClient(): ServicesApiInterface {

            if (servicesApiInterface == null) {

                val restAdapter = RestAdapter.Builder()
                    .setEndpoint("https://itunes.apple.com")
                    .setClient(OkClient(getClient()))
                    .build()

                servicesApiInterface = restAdapter.create(ServicesApiInterface::class.java!!)
            }
            return servicesApiInterface as ServicesApiInterface
        }

        fun getClient(): OkHttpClient {
            val client = OkHttpClient()
            return client
        }
    }



    interface ServicesApiInterface {
        @GET("/search?mediaType=music&limit=20")
        fun tracks(@Query("term") music:String, callback: Callback<TrackSearchResponse>)
    }



}