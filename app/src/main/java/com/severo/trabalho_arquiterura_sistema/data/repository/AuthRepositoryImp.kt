package com.severo.trabalho_arquiterura_sistema.data.repository

import com.severo.trabalho_arquiterura_sistema.data.model.User
import com.severo.trabalho_arquiterura_sistema.util.UiState

class AuthRepositoryImp() : AuthRepository {

    override fun registerUser(
        email: String,
        password: String,
        user: User, result: (UiState<User>) -> Unit
    ) {
        result.invoke(
            UiState.Success(user)
        )
    }

    override fun loginUser(
        email: String,
        password: String,
        result: (UiState<String>) -> Unit
    ) {
        result.invoke(UiState.Success("Login successfully!"))
    }
}