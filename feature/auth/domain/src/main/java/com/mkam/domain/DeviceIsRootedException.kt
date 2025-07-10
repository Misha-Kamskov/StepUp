package com.mkam.domain

import com.mkam.essentials.exceptions.base.AbstractAppException
import com.mkam.essentials.exceptions.base.WithLocalizedMessage
import com.mkam.essentials.resources.StringProviderStore


abstract class AuthAppException(
    message: String,
    cause: Throwable? = null,
) : AbstractAppException(message, cause), WithLocalizedMessage {

    override fun getLocalizedMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedMessage(stringProviderStore.get<AuthStringProvider>())
    }

    abstract fun getLocalizedMessage(stringProvider: AuthStringProvider): String
}


class DeviceIsRootedException : AuthAppException("Device is rooted") {
    override fun getLocalizedMessage(stringProvider: AuthStringProvider): String {
        return stringProvider.deviceIsRootedErrorMessage
    }
}