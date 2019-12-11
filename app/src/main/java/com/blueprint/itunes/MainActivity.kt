package com.blueprint.itunes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.GridLayoutManager
import com.blueprint.itunes.model.Track
import com.blueprint.itunes.presentation.adapter.TrackAdapter
import com.blueprint.itunes.viewmodel.TracksModel
import androidx.recyclerview.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    lateinit var adapter : TrackAdapter
    val model by viewModel<TracksModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = GridLayoutManager(this,2)

        list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {

                }
            }
        })


        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                model.search.value = s.toString()

            }
        }
        search_text.addTextChangedListener(watcher)


        model.getTracks().observe(this, object : Observer<List<Track>> {
            override fun onChanged(@Nullable data: List<Track>) {
                adapter = TrackAdapter(this@MainActivity, data as ArrayList<Track>)
                list.adapter = adapter
            }
        })
    }
}
