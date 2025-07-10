package com.mkam.essentials.exceptions.base

abstract class AbstractAppException(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause)
