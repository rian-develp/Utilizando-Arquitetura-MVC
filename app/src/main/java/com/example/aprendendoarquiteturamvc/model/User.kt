package com.example.aprendendoarquiteturamvc.model

class User constructor( private var nome: String, private var senha: String ){

     fun getNome(): String {
          return nome;
     }

     fun setNome(novoNome: String) {
          nome = novoNome
     }

     fun getSenha(): String {
          return senha
     }

     fun setSenha(novaSenha: String) {
          senha = novaSenha
     }
}