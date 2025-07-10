package com.mkam.essentials.exceptions.mapper

import com.mkam.essentials.logger.DefaultLogger
import com.mkam.essentials.logger.Logger

interface ExceptionToMessageMapper {

    fun getLocalizedMessage(exception: Exception): String

    companion object : ExceptionToMessageMapper{
        private var instance: ExceptionToMessageMapper = EmptyExceptionToMessageError()

        override fun getLocalizedMessage(exception: Exception): String {
            return instance.getLocalizedMessage(exception)
        }

        fun set(mapper: ExceptionToMessageMapper) {
            this.instance = mapper
        }

        fun reset(logger: Logger) {
            this.instance = EmptyExceptionToMessageError()
        }
    }

}