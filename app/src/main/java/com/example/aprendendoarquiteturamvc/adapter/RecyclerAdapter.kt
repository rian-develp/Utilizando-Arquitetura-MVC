package com.example.aprendendoarquiteturamvc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendendoarquiteturamvc.databinding.CardLayoutBinding
import com.example.aprendendoarquiteturamvc.model.Card

class RecyclerAdapter(private val context: Context, private val cardsList: MutableList<Card>)
    : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        val card = binding.card
        val cardName = binding.cardName
        val cardNumber = binding.cardNumber
        val cardValidity = binding.cardValidity
        val customerName = binding.customerName
        val cardImg = binding.cardImg
    }

    override fun getItemCount(): Int = cardsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = CardLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.card.setBackgroundColor(cardsList[position].color)
        holder.cardImg.setImageURI(cardsList[position].img.toUri())
        holder.cardName.text = cardsList[position].cardName
        holder.cardNumber.text = cardsList[position].cardNumber
        holder.cardValidity.text = cardsList[position].cardValidity
        holder.customerName.text = cardsList[position].customerName
    }
}
