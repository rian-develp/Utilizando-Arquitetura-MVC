package com.example.aprendendoarquiteturamvc.view.home

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendendoarquiteturamvc.adapter.RecyclerAdapter
import com.example.aprendendoarquiteturamvc.databinding.ActivityHomeBinding
import com.example.aprendendoarquiteturamvc.model.Card
import com.example.aprendendoarquiteturamvc.view.insertCard.InsertCardActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: RecyclerAdapter
    private val list = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewXML = binding.recyclerView
        recyclerViewXML.setHasFixedSize(true)
        recyclerViewXML.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        adapter = RecyclerAdapter(this, list)
        recyclerViewXML.adapter = adapter

        val floatingActionButton = binding.FAB
        floatingActionButton.setOnClickListener{
            val intent = Intent(this, InsertCardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}