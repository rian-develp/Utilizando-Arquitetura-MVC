package com.example.aprendendoarquiteturamvc.controller.cadastro

import com.example.aprendendoarquiteturamvc.database.Database
import com.example.aprendendoarquiteturamvc.model.User

class CadastroController: CadastroControllerInterface {

    override fun inserirUsuarioBancoDeDados(nomeUsuario: String, senhaUsuario: String) {
        Database.inserirUsuario(User(nomeUsuario, senhaUsuario))
    }
}