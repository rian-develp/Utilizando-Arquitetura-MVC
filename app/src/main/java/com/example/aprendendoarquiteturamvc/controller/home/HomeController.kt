package com.example.aprendendoarquiteturamvc.controller.home

import com.example.aprendendoarquiteturamvc.database.Database

class HomeController: HomeControllerInterface {

    override fun atualizarSenhaDoUsuario(nome: String, novaSenha: String): Boolean {
        val result = Database.atualizarSenhaUsuario(nome, novaSenha)
        return result
    }

    override fun deletarUsuario(nome: String): Boolean {
        val result = Database.deletarUsuario(nome)
        return result
    }
}