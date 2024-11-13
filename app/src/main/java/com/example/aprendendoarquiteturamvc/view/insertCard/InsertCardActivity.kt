package com.example.aprendendoarquiteturamvc.view.insertCard

import android.content.Context
import android.os.Bundle
import android.util.Log
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

        setCardName(this)
        val string = setCardColor(this)
        setCardNumber(this)
        setCardValidity(this)
        setCustomerName(this)

        binding.button.setOnClickListener {
            val cardName = binding.etCardName.text.toString().trim()
            val cardNumber = binding.etCardNumber.text.toString().trim()
            val cardValidity = binding.etCardValidity.text.toString().trim()
            val customerName = binding.customerName.text.toString().trim()
        }
    }

    private fun setCardColor(context: Context): String = with(binding){
        var string = ""
        etCardName.doAfterTextChanged { text ->
            when(text.toString().lowercase().trim()){
                "mastercard" -> {
                    string = ContextCompat.getColor(context, R.color.black).toString()
                    card.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
                }
                "itaú" -> {
                    string = ContextCompat.getColor(context, R.color.black).toString()
                    ContextCompat.getColor(context, android.R.color.holo_orange_dark)
                }
                "picpay" -> {
                    string = ContextCompat.getColor(context, R.color.black).toString()
                    card.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_dark))
                }
                "hipercard" -> {
                    string = ContextCompat.getColor(context, R.color.black).toString()
                    card.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_dark))
                }
                "nubank" -> {
                    string = ContextCompat.getColor(context, R.color.black).toString()
                    card.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_purple))
                }
                "caixa" -> {
                    string = ContextCompat.getColor(context, R.color.black).toString()
                    card.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_dark))
                }
                else -> ContextCompat.getColor(context, R.color.white)
            }
        }
        return string
    }

    private fun setCardName(context: Context) = with(binding){
        etCardName.doAfterTextChanged { text ->
            cardName.text = text.toString().trim()
            cardName.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    private fun setCardNumber(context: Context) = with(binding){
        etCardNumber.doAfterTextChanged { text ->
            cardNumber.text = text.toString().trim()
            cardNumber.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    private fun setCardValidity(context: Context) = with(binding){
        etCardValidity.doAfterTextChanged { text ->
            cardValidity.text = text.toString().trim()
            cardValidity.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    private fun setCustomerName(context: Context) = with(binding){
        etCustomerName.doAfterTextChanged {text ->
            customerName.text = text.toString().trim()
            customerName.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    fun goToHomeActivityWithTheCard(){

    }
}