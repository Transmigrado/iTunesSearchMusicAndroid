package com.blueprint.itunes.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blueprint.itunes.R
import com.blueprint.itunes.model.Track
import com.blueprint.itunes.presentation.View.MediaPlayerHolder
import kotlinx.android.synthetic.main.detail_track.*

class DetailTrack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_track)

        val track = this.intent.getParcelableExtra<Track>("data")


        val playerHolder = MediaPlayerHolder(this, track.previewUrl)
        playerHolder.play()


    }
}
