package com.severo.trabalho_arquiterura_sistema.presentation.home.registerclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severo.trabalho_arquiterura_sistema.data.repository.RegisterClientRepository
import com.severo.trabalho_arquiterura_sistema.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterClientViewModel @Inject constructor(
    val registerClientRepository: RegisterClientRepository
): ViewModel() {

    private val _registerClient = MutableLiveData<UiState<Boolean>>()
    val registerClient: LiveData<UiState<Boolean>>
        get() = _registerClient

    fun registerUser(
        name: String,
        phone: String,
        date: String,
        time: String
    ) {
        _registerClient.value = UiState.Loading
        registerClientRepository.registerUser(
            name = name,
            phone = phone,
            date = date,
            time = time
        ) { _registerClient.value = it }
    }
}