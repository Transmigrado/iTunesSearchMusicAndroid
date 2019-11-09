package com.blueprint.itunes.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blueprint.itunes.model.Track
import com.blueprint.itunes.presentation.holder.TrackHolder
import android.view.LayoutInflater
import com.blueprint.itunes.R


class TrackAdapter(ctx: Context, tracks: ArrayList<Track>) : RecyclerView.Adapter<TrackHolder>() {

    var ctx: Context
    var tracks: ArrayList<Track>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_view, parent, false)
        return TrackHolder(view)
    }

    override fun getItemCount(): Int {
       return tracks.size
    }

    override fun onBindViewHolder(holder: TrackHolder, position: Int) {

    }

    init {
        this.ctx = ctx
        this.tracks = tracks
    }
}
