package com.severo.trabalho_arquiterura_sistema.presentation.home.doctor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severo.trabalho_arquiterura_sistema.data.model.Client
import com.severo.trabalho_arquiterura_sistema.data.repository.HomeDoctorRepository
import com.severo.trabalho_arquiterura_sistema.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeDoctorViewModel @Inject constructor(
    val repository: HomeDoctorRepository
): ViewModel() {

    private val _allPatient = MutableLiveData<UiState<List<Client>>>()
    val allPatient: LiveData<UiState<List<Client>>>
        get() = _allPatient

    private val _allClientResult = MutableLiveData<UiState<List<Client>>>()
    val allClientResult: LiveData<UiState<List<Client>>>
        get() = _allClientResult

    init {
        getAllPatient()
        getAllClientResult()
    }

    private fun getAllPatient() {
        _allPatient.value = UiState.Loading
        repository.getAllPatient { _allPatient.value = it }
    }

    private fun getAllClientResult() {
        _allClientResult.value = UiState.Loading
        repository.getAllClientResult { _allClientResult.value = it }
    }
}