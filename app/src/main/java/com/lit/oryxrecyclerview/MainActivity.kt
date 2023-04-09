package com.lit.oryxrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // We find RecyclerView  using ID recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Layout Manager sets Recycler View Go vertical
        val layoutManager = LinearLayoutManager(this)

        // Put the layout Manager to recyclerView - View will be vertical
        recyclerView.layoutManager = layoutManager

        // Access the RecyclerAdapter(Has the Foods Arrays Data)  and store in adapter variable
        val adapter = RecyclerAdapter(applicationContext)

        // Set the adapter to Recycler View
        recyclerView.adapter = adapter
        //Your Recycler Now has the Data from Recycler Adapter.
        // RUN the App

    }
}