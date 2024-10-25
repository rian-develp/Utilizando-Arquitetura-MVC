package com.example.aprendendoarquiteturamvc.utils.validationFunctions

fun validBirthdate(date: String): Boolean {
    var isValidDate = false
    if(date.length == 10){
        isValidDate = true
    }
        return isValidDate
}