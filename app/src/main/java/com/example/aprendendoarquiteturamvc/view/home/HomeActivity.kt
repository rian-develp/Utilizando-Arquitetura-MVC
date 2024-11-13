package com.example.aprendendoarquiteturamvc.view.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aprendendoarquiteturamvc.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent


        val nomeUsuario = intent.getStringExtra("nomeUsuario")
        val senhaUsuario = intent.getStringExtra("senhaUsuario")

        binding.edtNome.text = "Nome do Usuário: $nomeUsuario"
        binding.edtSenha.text = "Senha do Usuário: $senhaUsuario"

    }
}