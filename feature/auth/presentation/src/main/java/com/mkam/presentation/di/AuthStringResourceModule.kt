package com.mkam.presentation.di

import com.mkam.domain.AuthStringProvider
import com.mkam.essentials.resources.CoreStringProvider
import com.mkam.essentials.resources.StringProvider
import com.mkam.presentation.AuthStringProviderImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface AuthStringResourceModule {

    @Binds
    @IntoMap
    @ClassKey(AuthStringProvider::class)
    fun bindAuthStringProvider(
        impl: AuthStringProviderImp
    ): StringProvider
}