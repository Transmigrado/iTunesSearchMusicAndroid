package com.blueprint.itunes.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.blueprint.itunes.BR
import com.blueprint.itunes.R
import com.blueprint.itunes.databinding.DetailTrackBinding
import com.blueprint.itunes.model.Track
import com.blueprint.itunes.presentation.view.MediaPlayerHolder


class DetailTrack : AppCompatActivity() {

    lateinit var playerHolder : MediaPlayerHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val track = this.intent.getParcelableExtra<Track>("data")

        playerHolder = MediaPlayerHolder(this, track.previewUrl)

        val binding : DetailTrackBinding =  DataBindingUtil.setContentView(this, R.layout.detail_track)
        binding.setVariable(BR.track, track)
        binding.setVariable(BR.media, playerHolder)
    }

    override fun onDestroy() {
        super.onDestroy()
        playerHolder.stop()
    }
}
