package com.severo.trabalho_arquiterura_sistema.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.severo.trabalho_arquiterura_sistema.data.model.User
import com.severo.trabalho_arquiterura_sistema.data.repository.AuthRepository
import com.severo.trabalho_arquiterura_sistema.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    val repository: AuthRepository
): ViewModel() {

    private val _register = MutableLiveData<UiState<User>>()
    val register: LiveData<UiState<User>>
        get() = _register

    fun register(
        email: String,
        password: String,
        user: User
    ) {
        _register.value = UiState.Loading
        repository.registerUser(
            email = email,
            password = password,
            user = user
        ) { _register.value = it }
    }
}