package com.blueprint.itunes.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blueprint.itunes.model.Track
import com.blueprint.itunes.presentation.holder.TrackHolder
import android.view.LayoutInflater
import com.blueprint.itunes.R
import com.blueprint.itunes.presentation.activity.DetailTrack
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*
import androidx.core.app.ActivityOptionsCompat
import android.app.Activity


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
        val track = tracks.get(position)
        holder.itemView.setOnClickListener {

            val intent = Intent(this.ctx, DetailTrack::class.java).apply {
                this.putExtra("data", track)
            }
            val activityOptionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(ctx as Activity, holder.itemView.image, "cover")
            this.ctx.startActivity(intent, activityOptionsCompat.toBundle())
        }
        holder.itemView.artist_name.text = track.artistName
        holder.itemView.track_name.text = track.trackName
        Picasso.get().load(track.artworkUrl100).into(holder.itemView.image)
    }

    init {
        this.ctx = ctx
        this.tracks = tracks
    }
}
