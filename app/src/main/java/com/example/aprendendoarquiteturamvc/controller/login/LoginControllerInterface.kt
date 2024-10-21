package com.example.aprendendoarquiteturamvc.controller.login

interface LoginControllerInterface {

    fun doLogin(nome: String, senha: String): Boolean
}