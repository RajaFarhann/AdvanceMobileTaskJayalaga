package com.jayalaga.advancemobiletask.di

import com.google.firebase.auth.FirebaseAuth
import com.jayalaga.advancemobiletask.data.firebase.AuthRepository
import com.jayalaga.advancemobiletask.data.firebase.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth()= FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(firebaseAuth: FirebaseAuth): AuthRepository{
        return AuthRepositoryImpl(firebaseAuth)
    }

}