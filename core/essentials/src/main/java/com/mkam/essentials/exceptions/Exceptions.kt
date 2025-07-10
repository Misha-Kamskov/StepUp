package com.mkam.essentials.exceptions

import com.mkam.essentials.exceptions.base.AbstractAppException
import com.mkam.essentials.exceptions.base.AbstractCoreAppException
import com.mkam.essentials.resources.CoreStringProvider

class ConnectionException(
    cause: Throwable? = null,
) : AbstractCoreAppException("Network error", cause) {

    override fun getLocalizedMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.connectionErrorMessage
    }
}

class UnknownException : AbstractAppException("Unknown exception")
