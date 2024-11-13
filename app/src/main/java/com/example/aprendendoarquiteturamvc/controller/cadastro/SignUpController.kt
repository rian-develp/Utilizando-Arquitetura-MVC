package com.example.aprendendoarquiteturamvc.controller.cadastro

import com.example.aprendendoarquiteturamvc.model.User

class SignUpController: SignUpControllerInterface {

    private lateinit var user: User

    override fun signUp(name: String, birthdate: String, numberPhone: String, email: String) {
        user = User(name, birthdate, numberPhone, email)
    }


}