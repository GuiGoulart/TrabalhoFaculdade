package com.severo.trabalho_arquiterura_sistema.data.repository

import com.severo.trabalho_arquiterura_sistema.data.model.Client
import com.severo.trabalho_arquiterura_sistema.util.UiState

interface HomeReceptionistRepository {
    fun getAllClient(result: (UiState<List<Client>>) -> Unit)
}