package com.blueprint.itunes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.blueprint.itunes.model.Track
import com.blueprint.itunes.presentation.adapter.TrackAdapter
import com.blueprint.itunes.viewmodel.TracksModel



class MainActivity : AppCompatActivity() {

    lateinit var adapter : TrackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = GridLayoutManager(this,2)
        val model = ViewModelProviders.of(this).get(TracksModel::class.java!!)


        model.getTracks().observe(this, object : Observer<List<Track>> {
            override fun onChanged(@Nullable data: List<Track>) {
                adapter = TrackAdapter(this@MainActivity, data as ArrayList<Track>)
                list.adapter = adapter
            }
        })
    }
}
