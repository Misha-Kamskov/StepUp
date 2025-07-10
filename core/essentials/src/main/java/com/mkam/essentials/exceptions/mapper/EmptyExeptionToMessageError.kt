package com.mkam.essentials.exceptions.mapper

class EmptyExceptionToMessageError : ExceptionToMessageMapper {

    override fun getLocalizedMessage(exception: Exception): String {
        return exception.message ?: "Unknown error occurred"
    }
}