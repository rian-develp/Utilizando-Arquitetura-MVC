package com.example.aprendendoarquiteturamvc.view.cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.aprendendoarquiteturamvc.controller.cadastro.CadastroController
import com.example.aprendendoarquiteturamvc.databinding.ActivityCadastroBinding
import com.example.aprendendoarquiteturamvc.utils.functions.validarNome
import com.example.aprendendoarquiteturamvc.utils.functions.validarSenha
import com.example.aprendendoarquiteturamvc.view.login.LoginActivity

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botaoIrParaTelaLogin = binding.irParaTelaLogin
        val botaoCadastro = binding.botaoFazerCadastro
        val edtNome = binding.edtNome
        val edtSenha = binding.edtSenha

        irParaTelaLogin(botaoIrParaTelaLogin)

        fazerCadastro(botaoCadastro, edtNome, edtSenha)
    }

    fun irParaTelaLogin(botao: AppCompatButton){

        botao.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun fazerCadastro(botao: AppCompatButton, edtNome: EditText, edtSenha: EditText){

        val controller = CadastroController()

        botao.setOnClickListener {
            val nomeUsuario = edtNome.text.toString()
            val senhaUsuario = edtSenha.text.toString()

            val resultadoValidacaoNome = validarNome(nomeUsuario)
            val resultadoValidacaoSenha = validarSenha(senhaUsuario)

            if (resultadoValidacaoNome && resultadoValidacaoSenha){
                controller.inserirUsuarioBancoDeDados(nomeUsuario, senhaUsuario)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else if (!resultadoValidacaoNome){
                Toast.makeText(this, "Nome Inválido", Toast.LENGTH_SHORT).show()
            } else if(!resultadoValidacaoSenha)
                Toast.makeText(this, "Por favor, crie uma senha com mais de 5 caracteres", Toast.LENGTH_SHORT).show()
        }
    }
}