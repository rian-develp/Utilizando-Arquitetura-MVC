package com.example.aprendendoarquiteturamvc.utils.extensions

import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.aprendendoarquiteturamvc.utils.masks.MaskEditText

fun EditText.setMask(mask: String) {
    addTextChangedListener {
        MaskEditText(
            mask,
            this
        )
    }
}