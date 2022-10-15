package com.severo.trabalho_arquiterura_sistema.presentation.home.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severo.trabalho_arquiterura_sistema.data.model.DetailClient
import com.severo.trabalho_arquiterura_sistema.data.repository.DetailClientRepository
import com.severo.trabalho_arquiterura_sistema.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailClientViewModel @Inject constructor(
    val repository: DetailClientRepository
): ViewModel() {

    private val _detailClient = MutableLiveData<UiState<DetailClient>>()
    val detailClient: LiveData<UiState<DetailClient>>
        get() = _detailClient

    init {
        getAllPatient()
    }

    private fun getAllPatient() {
        _detailClient.value = UiState.Loading
        repository.getlDetailClient { _detailClient.value = it }
    }
}