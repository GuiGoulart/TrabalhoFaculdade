package com.severo.trabalho_arquiterura_sistema.helper

import com.google.firebase.auth.FirebaseUser

interface UserFirebase {

    fun getIdUser(): String

    fun getUser(): FirebaseUser

    fun typeUser(type: String): Boolean

}