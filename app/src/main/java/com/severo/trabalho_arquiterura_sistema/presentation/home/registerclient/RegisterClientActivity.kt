package com.severo.trabalho_arquiterura_sistema.presentation.home.registerclient

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.severo.trabalho_arquiterura_sistema.databinding.ActivityRegisterClientBinding
import com.severo.trabalho_arquiterura_sistema.util.UiState
import com.severo.trabalho_arquiterura_sistema.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterClientBinding
    private val viewModel: RegisterClientViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        listener()
        observer()
    }

    private fun listener() {
        binding.buttonRegister.setOnClickListener {
            if(validation()) {
                viewModel.registerUser(
                    name = binding.editName.text.toString(),
                    phone = binding.editPhone.text.toString(),
                    date = binding.editDate.text.toString(),
                    time = binding.editTime.text.toString()
                )
            }

        }
    }

    private fun validation(): Boolean {
        return when {
            binding.editName.text.toString().isEmpty() -> {
                toast("Por favor Digite o seu nome")
                false
            }
            binding.editPhone.text.toString().isEmpty() -> {
                toast("Por favor Digite o seu Telefone")
                false
            }
            binding.editDate.text.toString().isEmpty() -> {
                toast("Por favor digite a sua data de agendamento")
                false
            }
            binding.editTime.text.toString().isEmpty() -> {
                toast("Por favor digite o seu horario de agendamento")
                false
            }
            else -> {
                true
            }
        }
    }

    private fun observer() {
        viewModel.registerClient.observe(this) { state ->
            when (state) {
                is UiState.Loading -> {
                    toast("Cadatrando Cliente")
                }
                is UiState.Failure -> {
                    toast("Erro ao cadastrar cliente")
                }
                is UiState.Success -> {
                    toast("Usuario Cadastrado com Sucesso")
                    finish()
                }
            }
        }
    }
}