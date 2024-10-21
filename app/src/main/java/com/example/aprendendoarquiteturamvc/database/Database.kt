package com.example.aprendendoarquiteturamvc.database

import com.example.aprendendoarquiteturamvc.model.User
import java.util.ArrayList

object Database {
    private val database: ArrayList<User> = ArrayList()
    private var validBool = false

    fun inserirUsuario(user: User): Boolean{
        database.add(user)
        return true
    }

    fun verificaUsuario(nome: String, senha: String): Boolean {
        database.forEach {users ->
            if(users.getNome() == nome && users.getSenha() == senha){
                validBool = true
            }
        }
        return validBool
    }

    fun deletarUsuario(nome: String): Boolean{
        database.forEachIndexed {index,users ->
            if(users.getNome() == nome){
                database.removeAt(index)
                validBool = true
            }
        }
        return validBool
    }

    fun atualizarSenhaUsuario(nome: String, novaSenha: String): Boolean{
        database.forEachIndexed {index,users ->
            if(users.getNome() == nome){
                users.setSenha(novaSenha)
                validBool = true
            }
        }
        return validBool
    }
}