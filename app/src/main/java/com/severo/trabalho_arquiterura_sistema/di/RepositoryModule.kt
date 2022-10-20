package com.severo.trabalho_arquiterura_sistema.di

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
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImp()
    }

    @Singleton
    @Provides
    fun provideHomeDoctorRepository(): HomeDoctorRepository {
        return HomeDoctorRepositoryImp()
    }

    @Singleton
    @Provides
    fun provideDetailClientRepository(): DetailClientRepository {
        return DetailClientRepositoryImp()
    }

    @Singleton
    @Provides
    fun provideRegisterClientRepository(): RegisterClientRepository {
        return RegisterClientRepositoryImp()
    }

    @Singleton
    @Provides
    fun provideHomeReceptionistRepository(): HomeReceptionistRepository {
        return HomeReceptionistRepositoryImp()
    }
}