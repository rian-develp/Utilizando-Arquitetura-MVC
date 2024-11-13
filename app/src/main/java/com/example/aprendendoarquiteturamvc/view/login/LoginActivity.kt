package com.example.aprendendoarquiteturamvc.view.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aprendendoarquiteturamvc.R
import com.example.aprendendoarquiteturamvc.databinding.ActivityLoginBinding
import com.example.aprendendoarquiteturamvc.utils.validationFunctions.validEmail
import com.example.aprendendoarquiteturamvc.utils.validationFunctions.validPassword
import com.example.aprendendoarquiteturamvc.view.home.HomeActivity
import com.example.aprendendoarquiteturamvc.view.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToSignUpActivity()

        val buttonDoLogin = binding.buttonDoLogin

        buttonDoLogin.setOnClickListener {
            val email = binding.etMail.text.toString().trim()
            val password = binding.etPass.text.toString().trim()
            val resultValidationEmail = validEmail(email)
            val resultValidationPassword = validPassword(password)

            if(resultValidationEmail && resultValidationPassword)
                doLogin()
            else
                Toast.makeText(this, getString(R.string.invalid_email_or_password), Toast.LENGTH_SHORT).show()
        }

    }

    fun goToSignUpActivity(){
        val txtGoToSignUpActivity = binding.etGoToSignupActivity
        txtGoToSignUpActivity.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun doLogin(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}