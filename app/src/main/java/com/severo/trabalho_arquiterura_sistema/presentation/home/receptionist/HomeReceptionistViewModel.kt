package com.severo.trabalho_arquiterura_sistema.presentation.home.receptionist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severo.trabalho_arquiterura_sistema.data.model.Client
import com.severo.trabalho_arquiterura_sistema.data.repository.HomeReceptionistRepository
import com.severo.trabalho_arquiterura_sistema.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeReceptionistViewModel @Inject constructor(
    private val repository: HomeReceptionistRepository
): ViewModel() {

    private val _allClientResult = MutableLiveData<UiState<List<Client>>>()
    val allClientResult: LiveData<UiState<List<Client>>>
        get() = _allClientResult

    init {
        getAllClientResult()
    }

    private fun getAllClientResult() {
        _allClientResult.value = UiState.Loading
        repository.getAllClient { _allClientResult.value = it }
    }
}