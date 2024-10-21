package com.example.aprendendoarquiteturamvc.controller.login

import com.example.aprendendoarquiteturamvc.database.Database

class LoginController: LoginControllerInterface {

    override fun doLogin(nome: String, senha: String): Boolean {
        val validationResult = Database.verificaUsuario(nome, senha)
        return validationResult
    }
}