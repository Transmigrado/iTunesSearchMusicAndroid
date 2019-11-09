package com.blueprint.itunes.presentation.View

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri

class MediaPlayerHolder(ctx:Context, url:String?) {

    var mediaPlayer : MediaPlayer

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


}