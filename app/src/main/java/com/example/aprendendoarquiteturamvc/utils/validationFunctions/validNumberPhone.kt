package com.example.aprendendoarquiteturamvc.utils.validationFunctions

import java.util.regex.Pattern

fun validNumberPhone(numberPhone: String): Boolean {
    var isValidNumberPhone = false
    
    if (Pattern.compile("\\(?[1-9][1-9]\\)?[\\s]?(9[0-9]{4}|8[0-9]{3})[-]?([0-9]{4})").matcher(numberPhone).matches()){
        isValidNumberPhone = true
    }

    return isValidNumberPhone
}