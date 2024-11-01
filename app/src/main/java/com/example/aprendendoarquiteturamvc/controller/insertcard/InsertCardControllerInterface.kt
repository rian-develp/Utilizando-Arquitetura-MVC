package com.example.aprendendoarquiteturamvc.controller.insertcard

import com.example.aprendendoarquiteturamvc.model.Card

interface InsertCardControllerInterface {
    fun createCard(card: Card): Boolean
}