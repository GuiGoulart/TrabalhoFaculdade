package com.severo.trabalho_arquiterura_sistema.presentation.register

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.severo.trabalho_arquiterura_sistema.R
import com.severo.trabalho_arquiterura_sistema.data.model.User
import com.severo.trabalho_arquiterura_sistema.databinding.ActivityRegisterBinding
import com.severo.trabalho_arquiterura_sistema.presentation.home.doctor.HomeDoctorActivity
import com.severo.trabalho_arquiterura_sistema.presentation.home.receptionist.HomeReceptionistActivity
import com.severo.trabalho_arquiterura_sistema.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        validationCheckFunction()
    }

    private fun init() {
        observer()
        binding.registerBtn.setOnClickListener {
            if (validation()) {
                viewModel.register(
                    email = binding.emailEt.text.toString(),
                    password = binding.passEt.text.toString(),
                    user = getUserObj()
                )
            }
        }
        binding.imageBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun validationCheckFunction() {
        binding.switchDoctor.setOnClickListener {
            if (binding.switchReceptionist.isChecked) {
                binding.switchReceptionist.isChecked = false
            }
        }

        binding.switchReceptionist.setOnClickListener {
            if (binding.switchDoctor.isChecked) {
                binding.switchDoctor.isChecked = false
            }
        }
    }

    private fun observer() {
        viewModel.register.observe(this) { state ->
            when (state) {
                is UiState.Loading -> {
                    binding.registerBtn.text = ""
                    binding.registerProgress.show()
                }
                is UiState.Failure -> {
                    binding.registerBtn.text = "Register"
                    binding.registerProgress.hide()
                    toast(state.error)
                }
                is UiState.Success -> {
                    binding.registerBtn.text = "Register"
                    binding.registerProgress.hide()
                    toast(getString(R.string.register_sucess))
                    if (state.data.function === "Doctor") {
                        startActivity(Intent(this, HomeDoctorActivity::class.java))
                    } else {
                        startActivity(Intent(this, HomeReceptionistActivity::class.java))
                    }
                }
            }
        }
    }

    private fun getUserObj(): User {
        return User(
            id = "",
            first_name = binding.firstNameEt.text.toString(),
            function = if (binding.switchDoctor.isChecked) "Doctor" else "Receptionist",
            email = binding.emailEt.text.toString(),
        )
    }

    private fun validation(): Boolean {
        var isValid = true

        if (!binding.switchDoctor.isChecked && !binding.switchReceptionist.isChecked) {
            isValid = false
            toast(getString(R.string.enter_function))
        }

        if (binding.firstNameEt.text.isNullOrEmpty()) {
            isValid = false
            toast(getString(R.string.enter_first_name))
        }

        if (binding.emailEt.text.isNullOrEmpty()) {
            isValid = false
            toast(getString(R.string.enter_email))
        } else {
            if (!binding.emailEt.text.toString().isValidEmail()) {
                isValid = false
                toast(getString(R.string.invalid_email))
            }
        }
        if (binding.passEt.text.isNullOrEmpty()) {
            isValid = false
            toast(getString(R.string.enter_password))
        } else {
            if (binding.passEt.text.toString().length < 8) {
                isValid = false
                toast(getString(R.string.invalid_password))
            }
        }
        return isValid
    }
}