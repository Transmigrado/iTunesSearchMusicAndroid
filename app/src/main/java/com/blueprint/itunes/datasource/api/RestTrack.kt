package com.blueprint.itunes.datasource.api

import com.blueprint.itunes.model.Track
import com.blueprint.itunes.model.TrackSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestTrack {

    private var servicesApiInterface: ApiClient.ServicesApiInterface
    private var request : Call<TrackSearchResponse>? = null

    init {
        servicesApiInterface = ApiClient.getApiClient()
    }

    fun fetch(author:String, pages: Int, callback: CallBack){

        if(request != null){
            request!!.cancel()
        }

        request = servicesApiInterface.tracks(author,pages * 20)

        request!!.enqueue(object : Callback<TrackSearchResponse> {
            override fun onResponse(call: Call<TrackSearchResponse>, response: Response<TrackSearchResponse>) {
                callback.response(response.body()!!.results)
            }

            override fun onFailure(call: Call<TrackSearchResponse>, t: Throwable) {

            }
        })

    }


    interface CallBack {
        fun response(tracks: ArrayList<Track>)
    }
}