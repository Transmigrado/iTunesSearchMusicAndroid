package com.blueprint.itunes.presentation.view

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blueprint.itunes.BR
import com.blueprint.itunes.model.Track


class MediaPlayerHolder(ctx:Context, url:String?) : ViewModel() {


    var mediaPlayer : MediaPlayer

    var progress = 0
        get() = mediaPlayer.currentPosition


    var progressString: String = ""
        get() = mediaPlayer.currentPosition.toString()



    var duration = 100
        get() = mediaPlayer.duration



    init {
        val myUri  = Uri.parse(url)
        mediaPlayer = MediaPlayer().apply {
            setDataSource(ctx, myUri)
            prepare()
        }

    }

    fun play(){
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start()
        }
    }

    fun pause(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause()
        }
    }

    fun toggle(){
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start()
        }else{
            mediaPlayer.pause()
        }


        mediaPlayer.setOnInfoListener { mediaPlayer, i, f ->
            Log.d("TAG",mediaPlayer.currentPosition.toString())

            true
        }

        mediaPlayer.setOnBufferingUpdateListener { mediaPlayer, i ->

        }
    }

    fun stop(){
        mediaPlayer.stop()
    }


}