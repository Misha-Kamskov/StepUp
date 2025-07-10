package com.mkam.common_android

import android.app.Application
import com.mkam.common_android.logger.AndroidLogger
import com.mkam.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.mkam.essentials.logger.Logger
import timber.log.Timber
import javax.inject.Inject

abstract class AbstractApplication : Application() {

    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var exceptionToMessageMapper: ExceptionToMessageMapper

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Logger.set(logger)
        ExceptionToMessageMapper.set(exceptionToMessageMapper)
    }
}