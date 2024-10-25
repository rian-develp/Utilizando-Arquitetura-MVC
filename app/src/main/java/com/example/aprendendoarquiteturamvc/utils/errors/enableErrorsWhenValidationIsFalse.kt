package com.example.aprendendoarquiteturamvc.utils.errors

import com.google.android.material.textfield.TextInputLayout

fun enableErrorsWhenValidationIsFalse(field: TextInputLayout, message: String){
    field.isErrorEnabled = true
    field.error = message
}