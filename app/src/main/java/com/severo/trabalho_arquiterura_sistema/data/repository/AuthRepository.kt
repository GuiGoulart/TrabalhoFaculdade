package com.severo.trabalho_arquiterura_sistema.data.repository

import com.severo.trabalho_arquiterura_sistema.data.model.User
import com.severo.trabalho_arquiterura_sistema.util.UiState

interface AuthRepository {
    fun registerUser(email: String, password: String, user: User, result: (UiState<User>) -> Unit)
    fun loginUser(email: String, password: String, result: (UiState<String>) -> Unit)
}