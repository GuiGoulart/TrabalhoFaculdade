package com.severo.trabalho_arquiterura_sistema.data.repository

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.severo.trabalho_arquiterura_sistema.data.model.DetailClient
import com.severo.trabalho_arquiterura_sistema.data.model.HistoricClient
import com.severo.trabalho_arquiterura_sistema.util.UiState

class DetailClientRepositoryImp(
    val auth: FirebaseAuth,
    val database: FirebaseFirestore,
    val appPreferences: SharedPreferences,
    val gson: Gson
) : DetailClientRepository {

    override fun getlDetailClient(result: (UiState<DetailClient>) -> Unit) {
        result.invoke(
            UiState.Success(
                DetailClient(
                    id = "2",
                    name = "Paciente: Silas Borgues",
                    date = "Data: 20/10/2022",
                    hour = "Hora: 12:00",
                    result = listOf(
                        HistoricClient(
                            description = "Problema para apresentar trabalho",
                            result = "Um diagnóstico médico é um evento crucial na vida de uma pessoa. Os pacientes devem entender que os médicos devem realizar exames completos antes de dar-lhes um diagnóstico.",
                            date = "Data: 20/10/2022",
                            hour = "Hora: 12:00",
                        ),
                        HistoricClient(
                            description = "Problema para apresentar trabalho",
                            result = "Um diagnóstico médico é um evento crucial na vida de uma pessoa. Os pacientes devem entender que os médicos devem realizar exames completos antes de dar-lhes um diagnóstico.",
                            date = "Data: 20/10/2022",
                            hour = "Hora: 12:00",
                        ),
                    )
                )
            )
        )
    }
}