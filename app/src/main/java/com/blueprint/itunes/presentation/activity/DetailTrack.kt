package com.blueprint.itunes.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blueprint.itunes.R
import com.blueprint.itunes.model.Track
import com.blueprint.itunes.presentation.View.MediaPlayerHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_track.*

class DetailTrack : AppCompatActivity() {

    lateinit var playerHolder : MediaPlayerHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_track)

        val track = this.intent.getParcelableExtra<Track>("data")

        Picasso.get().load(track.artworkUrl100).into(image)
        playerHolder = MediaPlayerHolder(this, track.previewUrl)



    }

    override fun onDestroy() {
        super.onDestroy()
        playerHolder.stop()
    }
}
