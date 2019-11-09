package com.blueprint.itunes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.blueprint.itunes.datasource.api.RestTrack
import com.blueprint.itunes.model.Track


class TracksModel : ViewModel(){

    private var tracks: MutableLiveData<ArrayList<Track>>? = null


    fun getTracks(): LiveData<ArrayList<Track>> {

        if (tracks == null) {
            tracks = MutableLiveData()
            loadTracks()
        }


        return tracks as MutableLiveData<ArrayList<Track>>
    }



    private fun loadTracks() {

        val rest = RestTrack()
        rest.fetch("foals", object : RestTrack.CallBack {
            override fun response(tracks: ArrayList<Track>) {
                this@TracksModel.tracks!!.value = tracks
            }
        })

    }
}