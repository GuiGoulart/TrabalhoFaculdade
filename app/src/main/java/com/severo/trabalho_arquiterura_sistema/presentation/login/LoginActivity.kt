package com.severo.trabalho_arquiterura_sistema.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.severo.trabalho_arquiterura_sistema.R
import com.severo.trabalho_arquiterura_sistema.databinding.ActivityLoginBinding
import com.severo.trabalho_arquiterura_sistema.presentation.home.HomeReceptionistActivity
import com.severo.trabalho_arquiterura_sistema.presentation.home.doctor.HomeDoctorActivity
import com.severo.trabalho_arquiterura_sistema.presentation.register.RegisterActivity
import com.severo.trabalho_arquiterura_sistema.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        observer()
    }

    private fun init() {
        binding.buttonLogin.setOnClickListener {
            if (validation()){
                viewModel.login(
                    email = binding.textEmail.text.toString(),
                    password = binding.textPassword.text.toString()
                )
            }
        }

        binding.buttonRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun observer(){
        viewModel.login.observe(this){ state ->
            when(state){
                is UiState.Loading -> {
                    binding.buttonLogin.text = ""
                    binding.registerProgress.show()
                }
                is UiState.Failure -> {
                    binding.buttonLogin.text = "Login"
                    binding.registerProgress.hide()
                    toast(state.error)
                }
                is UiState.Success -> {
                    binding.buttonLogin.text = "Login"
                    binding.registerProgress.hide()
                    toast(getString(R.string.login_success))
                    if(binding.editTextEmail.text.toString() == "doctor@gmail.com") {
                        startActivity(Intent(this, HomeDoctorActivity::class.java))
                    } else {
                        startActivity(Intent(this, HomeReceptionistActivity::class.java))
                    }
                }
            }
        }
    }

    private fun validation(): Boolean {
        var isValid = true

        if (binding.editTextEmail.text.isNullOrEmpty()){
            isValid = false
            toast(getString(R.string.enter_email))
        }else{
            if (!binding.editTextEmail.text.toString().isValidEmail()){
                isValid = false
                toast(getString(R.string.invalid_email))
            }
        }

        if (binding.editTextPassword.text.isNullOrEmpty()){
            isValid = false
            toast(getString(R.string.enter_password))
        }else{
            if (binding.editTextPassword.text.toString().length < 8){
                isValid = false
                toast(getString(R.string.invalid_password))
            }
        }
        return isValid
    }
}