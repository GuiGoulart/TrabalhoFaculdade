package com.severo.trabalho_arquiterura_sistema.helper

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import javax.inject.Inject

class ConfigurationFirebaseImpl @Inject constructor() : ConfigurationFirebase {

    private var referenceFirebase: DatabaseReference? = null
    private var referenciaAutenticacao: FirebaseAuth? = null
    private var referenciaStorage: StorageReference? = null

    override fun getFirebase(): DatabaseReference {
        if (referenceFirebase == null) {
            referenceFirebase = FirebaseDatabase.getInstance().reference
        }
        return referenceFirebase as DatabaseReference
    }

    override fun getFirebaseAutenticacao(): FirebaseAuth {
        if (referenciaAutenticacao == null) {
            referenciaAutenticacao =
                FirebaseAuth.getInstance()
        }
        return referenciaAutenticacao as FirebaseAuth
    }

    override fun getFirebaseStorage(): StorageReference {
        if (referenciaStorage == null) {
            referenciaStorage =
                FirebaseStorage.getInstance().reference
        }
        return referenciaStorage as StorageReference
    }
}