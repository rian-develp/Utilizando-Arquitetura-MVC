package com.example.aprendendoarquiteturamvc.controller.insertcard

import com.example.aprendendoarquiteturamvc.model.Card

interface InsertCardControllerInterface {
    fun createCard(cardName: String, cardNumber: String, cardValidity: String, customerName: String, color: Int, img: String): Boolean
}