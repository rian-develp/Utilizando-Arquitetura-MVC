package com.example.aprendendoarquiteturamvc.view.insertCard

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.example.aprendendoarquiteturamvc.R
import com.example.aprendendoarquiteturamvc.controller.insertcard.InsertCardController
import com.example.aprendendoarquiteturamvc.databinding.ActivityInsertCardBinding

class InsertCardActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInsertCardBinding
    private val controller: InsertCardController = InsertCardController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setColorCard(this)
    }

    fun setColorCard(context: Context) = with(binding){
        etCardName.doAfterTextChanged { text ->
            card.setBackgroundColor(
                when(text.toString().lowercase()){
                    "mastercard" -> ContextCompat.getColor(context, R.color.black)
                    "itaú" -> ContextCompat.getColor(context, android.R.color.holo_orange_dark)
                    "picpay" -> ContextCompat.getColor(context, android.R.color.holo_green_dark)
                    "hipercard" -> ContextCompat.getColor(context, android.R.color.holo_red_dark)
                    "nubank" -> ContextCompat.getColor(context, android.R.color.holo_purple)
                    "caixa" -> ContextCompat.getColor(context, android.R.color.holo_blue_dark)
                    else -> ContextCompat.getColor(context, R.color.white)
                }
            )
        }
    }

    fun goToHomeActivityWithTheCard(){

    }
}