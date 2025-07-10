package com.mkam.common_android.di


import com.mkam.common_android.logger.AndroidLogger
import com.mkam.common_android.resources.CoreStringProviderImp
import com.mkam.essentials.exceptions.mapper.DefaultExceptionToMessageMapper
import com.mkam.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.mkam.essentials.logger.Logger
import com.mkam.essentials.resources.CoreStringProvider
import com.mkam.essentials.resources.StringProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface CommonAndroidModule {

    @Binds
    fun bindLogger(
        logger: AndroidLogger
    ): Logger

    @Binds
    @IntoMap
    @ClassKey(CoreStringProvider::class)
    fun bindCoreStringResources(
        impl: CoreStringProviderImp
    ): StringProvider

    @Binds
    fun bindExceptionToMessageMapper(
        impl: DefaultExceptionToMessageMapper
    ): ExceptionToMessageMapper
}