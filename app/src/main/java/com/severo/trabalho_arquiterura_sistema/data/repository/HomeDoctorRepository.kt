package com.severo.trabalho_arquiterura_sistema.data.repository

import com.severo.trabalho_arquiterura_sistema.data.model.Client
import com.severo.trabalho_arquiterura_sistema.util.UiState

interface HomeDoctorRepository {
    fun getAllPatient(result: (UiState<List<Client>>) -> Unit)
    fun getAllClientResult(result: (UiState<List<Client>>) -> Unit)
}