package com.blueprint.itunes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.blueprint.itunes.model.Track


class TracksModel : ViewModel(){

    private var tracks: MutableLiveData<List<Track>>? = null


    fun getTracks(): LiveData<List<Track>> {

        if (tracks == null) {
            tracks = MutableLiveData<List<Track>>()
            loadTracks()
        }


        return tracks as MutableLiveData<List<Track>>
    }



    private fun loadTracks() {


    }
}