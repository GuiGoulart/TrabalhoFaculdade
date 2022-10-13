package com.severo.trabalho_arquiterura_sistema.data.repository

import android.content.SharedPreferences
import com.google.firebase.auth.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.severo.trabalho_arquiterura_sistema.data.model.User
import com.severo.trabalho_arquiterura_sistema.util.FireStoreCollection
import com.severo.trabalho_arquiterura_sistema.util.SharedPrefConstants
import com.severo.trabalho_arquiterura_sistema.util.UiState

class AuthRepositoryImp(
    val auth: FirebaseAuth,
    val database: FirebaseFirestore,
    val appPreferences: SharedPreferences,
    val gson: Gson
) : AuthRepository {

    override fun registerUser(
        email: String,
        password: String,
        user: User, result: (UiState<String>) -> Unit
    ) {
        result.invoke(
            UiState.Success("User register successfully!")
        )
    }

    override fun loginUser(
        email: String,
        password: String,
        result: (UiState<String>) -> Unit
    ) {
        result.invoke(UiState.Success("Login successfully!"))
    }
}