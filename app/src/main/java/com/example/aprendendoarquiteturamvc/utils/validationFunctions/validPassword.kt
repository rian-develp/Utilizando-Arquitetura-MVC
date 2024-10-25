package com.example.aprendendoarquiteturamvc.utils.validationFunctions

fun validPassword(password: String): Boolean {
    var isValidPassword = false

    if(password.length > 5){
        isValidPassword = true
    }

    return isValidPassword
}