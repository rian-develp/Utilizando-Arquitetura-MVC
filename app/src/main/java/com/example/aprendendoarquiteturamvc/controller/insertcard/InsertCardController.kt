package com.example.aprendendoarquiteturamvc.controller.insertcard

import com.example.aprendendoarquiteturamvc.model.Card

class InsertCardController: InsertCardControllerInterface{

    private lateinit var card: Card

    override fun createCard(
        cardName: String,
        cardNumber: String,
        cardValidity: String,
        customerName: String,
        color: Int,
        img: String
    ): Boolean {
        card = Card(cardName, cardValidity, cardNumber, color, customerName, img)
        return true
    }


}