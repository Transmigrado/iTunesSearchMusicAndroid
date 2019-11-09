package com.blueprint.itunes.datasource.api

import com.blueprint.itunes.model.Track
import com.blueprint.itunes.model.TrackSearchResponse
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

class RestTrack {
    private var servicesApiInterface: ApiClient.ServicesApiInterface

    init {
        servicesApiInterface = ApiClient.getApiClient()
    }

    fun fetch(author:String, pages: Int, callback: CallBack){
        servicesApiInterface.tracks(author,pages * 20,object : Callback<TrackSearchResponse> {
            override fun success(trackResponse: TrackSearchResponse?, response: Response) {
                callback.response(trackResponse!!.results)
            }

            override fun failure(error: RetrofitError?) {

            }
        })
    }


    interface CallBack {
        fun response(tracks: ArrayList<Track>)
    }
}