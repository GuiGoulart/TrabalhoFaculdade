package com.severo.trabalho_arquiterura_sistema.data.repository

import com.severo.trabalho_arquiterura_sistema.data.model.DetailClient
import com.severo.trabalho_arquiterura_sistema.util.UiState

interface DetailClientRepository {
    fun getlDetailClient(result: (UiState<DetailClient>) -> Unit)
}