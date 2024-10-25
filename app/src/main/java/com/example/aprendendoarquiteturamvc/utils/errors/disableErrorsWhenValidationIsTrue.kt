package com.example.aprendendoarquiteturamvc.utils.errors

import com.google.android.material.textfield.TextInputLayout

fun disableErrorsWhenValidationIsTrue(field: TextInputLayout) {
    field.error = null
    field.isErrorEnabled = false
}