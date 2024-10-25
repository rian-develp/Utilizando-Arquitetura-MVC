package com.example.aprendendoarquiteturamvc.utils.validationFunctions

import android.util.Patterns

fun validEmail(email: String): Boolean{
    var isValidName = false

    if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        isValidName = true
    }

    return isValidName
}