package com.example.aprendendoarquiteturamvc.controller.cadastro

interface SignUpControllerInterface {
    fun signUp(name: String, birthdate: String, numberPhone: String, email: String)
}