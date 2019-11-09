package com.blueprint.itunes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.blueprint.itunes.model.Track
import com.blueprint.itunes.presentation.adapter.TrackAdapter
import com.blueprint.itunes.viewmodel.TracksModel
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var adapter : TrackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = GridLayoutManager(this,2)

        val model = ViewModelProviders.of(this).get(TracksModel::class.java!!)

        list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {
                    
                }
            }
        })

        model.getTracks().observe(this, object : Observer<List<Track>> {
            override fun onChanged(@Nullable data: List<Track>) {
                adapter = TrackAdapter(this@MainActivity, data as ArrayList<Track>)
                list.adapter = adapter
            }
        })
    }
}
