package com.blueprint.itunes.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blueprint.itunes.R
import com.blueprint.itunes.presentation.View.MediaPlayerHolder
import kotlinx.android.synthetic.main.detail_track.*

class DetailTrack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_track)

        val playerHolder = MediaPlayerHolder(this,"https://audio-ssl.itunes.apple.com/itunes-assets/Music5/v4/b5/92/77/b592775e-52e8-94ed-daf7-13a3f8bfc550/mzaf_7288708462612507242.plus.aac.p.m4a")
        playerHolder.play()

    }
}
