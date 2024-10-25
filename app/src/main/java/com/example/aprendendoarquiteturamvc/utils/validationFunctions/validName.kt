package com.example.aprendendoarquiteturamvc.utils.validationFunctions

import java.util.regex.Pattern

fun validName(name: String): Boolean{
    var isValidName = false

    if(Pattern.compile("^[A-Z][a-zA-Zà-úÀ-Ús.'-]+( [A-Z][a-zA-Zà-úÀ-Ús.'-]+)*\$").matcher(name).matches()){
        isValidName = true
    }

    return isValidName
}