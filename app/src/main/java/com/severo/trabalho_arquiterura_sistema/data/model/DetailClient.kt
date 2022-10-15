package com.severo.trabalho_arquiterura_sistema.data.model

data class DetailClient(
    val id: String = "",
    val name: String = "",
    val date: String = "",
    val hour: String = "",
    val result: List<HistoricClient> = listOf()
)

data class HistoricClient(
    val description: String = "",
    val result: String = "",
    val date: String = "",
    val hour: String = ""
)