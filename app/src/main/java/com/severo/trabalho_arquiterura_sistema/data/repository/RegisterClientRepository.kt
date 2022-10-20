package com.severo.trabalho_arquiterura_sistema.data.repository

import com.severo.trabalho_arquiterura_sistema.util.UiState

interface RegisterClientRepository {
    fun registerUser(
        name: String,
        phone: String,
        date: String,
        time: String,
        result: (UiState<Boolean>) -> Unit
    )
}