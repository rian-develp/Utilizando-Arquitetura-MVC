package com.example.aprendendoarquiteturamvc.utils.errors

import com.google.android.material.textfield.TextInputLayout

fun enableErrorsWhenFieldsAreEmptyOrBlank(field: TextInputLayout, message: String){
    field.isErrorEnabled = true
    field.error = message
}