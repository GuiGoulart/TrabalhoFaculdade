package com.severo.trabalho_arquiterura_sistema.data.repository

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.severo.trabalho_arquiterura_sistema.data.model.Client
import com.severo.trabalho_arquiterura_sistema.util.UiState

class HomeDoctorRepositoryImp(
    val auth: FirebaseAuth,
    val database: FirebaseFirestore,
    val appPreferences: SharedPreferences,
    val gson: Gson
) : HomeDoctorRepository {

    override fun getAllPatient(result: (UiState<List<Client>>) -> Unit) {
        result.invoke(UiState.Success(listOfClient()))
    }

    override fun getAllClientResult(result: (UiState<List<Client>>) -> Unit) {
        result.invoke(UiState.Success(listOfClient()))
    }

    private fun listOfClient() = listOf(
        Client(
            id = "2",
            title = "Paciente: Silas Borgues",
            description = "Problema para apresentar trabalho",
            date = "Data: 20/10/2022",
            hour = "Hora: 12:00"
        ),
        Client(
            id = "2",
            title = "Paciente: João Fukuda",
            description = "Problema para apresentar trabalho",
            date = "Data: 20/10/2022",
            hour = "Hora: 13:00"
        ),
        Client(
            id = "2",
            title = "Paciente: João Fukuda",
            description = "Problema para apresentar trabalho",
            date = "Data: 20/10/2022",
            hour = "Hora: 13:00"
        ),
    )
}