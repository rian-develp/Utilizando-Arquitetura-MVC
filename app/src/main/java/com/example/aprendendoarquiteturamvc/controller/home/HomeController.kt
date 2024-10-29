package com.example.aprendendoarquiteturamvc.controller.home

class HomeController: HomeControllerInterface {

    override fun atualizarSenhaDoUsuario(nome: String, novaSenha: String): Boolean {
        return true
    }

    override fun deletarUsuario(nome: String): Boolean {
        return false
    }
}