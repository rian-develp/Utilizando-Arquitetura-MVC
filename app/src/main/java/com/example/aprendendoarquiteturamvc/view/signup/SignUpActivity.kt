package com.example.aprendendoarquiteturamvc.view.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.aprendendoarquiteturamvc.R
import com.example.aprendendoarquiteturamvc.databinding.ActivitySignupBinding
import com.example.aprendendoarquiteturamvc.utils.errors.enableErrorsWhenFieldsAreEmptyOrBlank
import com.example.aprendendoarquiteturamvc.utils.validationFunctions.validEmail
import com.example.aprendendoarquiteturamvc.utils.validationFunctions.validName
import com.example.aprendendoarquiteturamvc.utils.errors.enableErrorsWhenValidationIsFalse
import com.example.aprendendoarquiteturamvc.utils.validationFunctions.validBirthdate
import com.example.aprendendoarquiteturamvc.utils.validationFunctions.validNumberPhone
import com.example.aprendendoarquiteturamvc.utils.validationFunctions.validPassword
import com.example.aprendendoarquiteturamvc.view.login.LoginActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonSignUp = binding.btnSignUp

        disableErrorsWhenUserInputTexts()

        buttonSignUp.setOnClickListener { validate() }

    }

    fun validate() = with(binding){

        val name = etName.text.toString().trim()
        val birthdate = etBirthdate.text.toString().trim()
        val numberPhone = etPhone.text.toString().trim()
        val email = etMail.text.toString().trim()
        val password = etPass.text.toString().trim()
        val confirmPassword = etConfirmPass.text.toString().trim()

        val isValidName = validName(name)
        val isValidEmail = validEmail(email)
        val isValidPhone = validNumberPhone(numberPhone)
        val isValidBirthdate = validBirthdate(birthdate)
        val isValidPassword = validPassword(password)

        if(!isValidName)
            enableErrorsWhenValidationIsFalse(tilName, getString(R.string.invalid_name))

        if(!isValidBirthdate)
            enableErrorsWhenValidationIsFalse(tilBirthdate, getString(R.string.invalid_birthdate))

        if(!isValidEmail)
            enableErrorsWhenValidationIsFalse(tilMail, getString(R.string.invalid_email))

        if(!isValidPhone)
            enableErrorsWhenValidationIsFalse(tilPhone, getString(R.string.invalid_numberPhone))

        if(!isValidPassword || (password.isBlank() || password.isEmpty())) {
            enableErrorsWhenValidationIsFalse(tilPass, getString(R.string.weak_password))
            return
        }

        if(isValidPassword && (confirmPassword.isEmpty() || confirmPassword.isBlank())) {
            enableErrorsWhenFieldsAreEmptyOrBlank(tilConfirmPass, getString(R.string.confirm_password_is_blank_or_empty))
            return
        }

        if(isValidPassword && confirmPassword != password)
            enableErrorWhenPasswordFieldAndConfirmPasswordAreDifferent()

        if(isValidName && isValidBirthdate && isValidPhone && isValidEmail && isValidPassword && confirmPassword == password){
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun disableErrorsWhenUserInputTexts() = with(binding){
        etName.doAfterTextChanged { tilName.isErrorEnabled = false }
        etBirthdate.doAfterTextChanged { tilBirthdate.isErrorEnabled = false }
        etPhone.doAfterTextChanged { tilPhone.isErrorEnabled = false }
        etMail.doAfterTextChanged { tilMail.isErrorEnabled = false }
        etPass.doAfterTextChanged { tilPass.isErrorEnabled = false }
        etConfirmPass.doAfterTextChanged { tilConfirmPass.isErrorEnabled = false }
    }

    fun enableErrorWhenPasswordFieldAndConfirmPasswordAreDifferent() = with(binding){
        tilConfirmPass.isErrorEnabled = true
        tilConfirmPass.error = getString(R.string.passwords_not_confirmed)
        tilPass.isErrorEnabled = true
        tilPass.error = getString(R.string.passwords_not_confirmed)
    }
}