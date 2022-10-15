package com.severo.trabalho_arquiterura_sistema.di

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.severo.trabalho_arquiterura_sistema.data.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(
        database: FirebaseFirestore,
        auth: FirebaseAuth,
        appPreferences: SharedPreferences,
        gson: Gson
    ): AuthRepository {
        return AuthRepositoryImp(auth, database, appPreferences, gson)
    }

    @Singleton
    @Provides
    fun provideHomeDoctorRepository(
        database: FirebaseFirestore,
        auth: FirebaseAuth,
        appPreferences: SharedPreferences,
        gson: Gson
    ): HomeDoctorRepository {
        return HomeDoctorRepositoryImp(auth, database, appPreferences, gson)
    }

    @Singleton
    @Provides
    fun provideDetailClientRepository(
        database: FirebaseFirestore,
        auth: FirebaseAuth,
        appPreferences: SharedPreferences,
        gson: Gson
    ): DetailClientRepository {
        return DetailClientRepositoryImp(auth, database, appPreferences, gson)
    }
}