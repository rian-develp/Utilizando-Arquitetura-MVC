package com.example.aprendendoarquiteturamvc.view.login

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aprendendoarquiteturamvc.controller.login.LoginController
import com.example.aprendendoarquiteturamvc.databinding.ActivityLoginBinding
import com.example.aprendendoarquiteturamvc.view.signup.SignUpActivity
import com.example.aprendendoarquiteturamvc.view.home.HomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var controller: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botaoEntrar = binding.botaoEntrar
        val botaoIrParaTelaCadastro = binding.botaoIrParaTelaCadastro
        val edtNome = binding.edtNome
        val edtSenha = binding.edtSenha

        botaoEntrar.setOnClickListener {irParaTelaHome(edtNome, edtSenha) }

        botaoIrParaTelaCadastro.setOnClickListener { irParaTelaCadastro() }

    }

    fun irParaTelaHome(edtNome: EditText, edtSenha: EditText){
        controller = LoginController()
        val nomeUsuario = edtNome.text.toString()
        val senhaUsuario = edtSenha.text.toString()

        val resultadoValidacao = controller.doLogin(nomeUsuario, senhaUsuario)

        if(resultadoValidacao){
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("nomeUsuario", nomeUsuario)
            intent.putExtra("senhaUsuario", senhaUsuario)
            startActivity(intent)
            finish()
        } else
            Toast.makeText(this, "Usuário ou Senha Estão Incorretos", Toast.LENGTH_SHORT).show()
    }

    fun irParaTelaCadastro() {

        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}