package com.severo.trabalho_arquiterura_sistema.helper

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class UserFirebaseImpl @Inject constructor(
    private val configurationFirebase: ConfigurationFirebase
): UserFirebase {
    override fun getIdUser(): String {
        val autenticacao: FirebaseAuth = configurationFirebase.getFirebaseAutenticacao()
        return autenticacao.currentUser!!.uid
    }

    override fun getUser(): FirebaseUser {
        val usuario: FirebaseAuth = configurationFirebase.getFirebaseAutenticacao()
        return usuario.currentUser!!
    }

    override fun typeUser(type: String): Boolean {
        return try {
            val user: FirebaseUser = getUser()
            val profile = UserProfileChangeRequest.Builder()
                .setDisplayName(type)
                .build()
            user.updateProfile(profile)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}