package com.severo.trabalho_arquiterura_sistema.helper

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference

interface ConfigurationFirebase {

    fun getFirebase(): DatabaseReference

    fun getFirebaseAutenticacao(): FirebaseAuth

    fun getFirebaseStorage(): StorageReference

}