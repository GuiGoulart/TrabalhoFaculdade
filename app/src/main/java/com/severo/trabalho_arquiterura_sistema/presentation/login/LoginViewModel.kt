package com.severo.trabalho_arquiterura_sistema.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severo.trabalho_arquiterura_sistema.data.repository.AuthRepository
import com.severo.trabalho_arquiterura_sistema.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val repository: AuthRepository
): ViewModel() {

    private val _login = MutableLiveData<UiState<String>>()
    val login: LiveData<UiState<String>>
        get() = _login

    fun login(
        email: String,
        password: String
    ) {
        _login.value = UiState.Loading
        repository.loginUser(
            email,
            password
        ) {
            _login.value = it
        }
    }
}