package com.example.aprendendoarquiteturamvc.controller.home

interface HomeControllerInterface {
    fun atualizarSenhaDoUsuario(nome: String, novaSenha: String): Boolean
    fun deletarUsuario(nome: String): Boolean
}