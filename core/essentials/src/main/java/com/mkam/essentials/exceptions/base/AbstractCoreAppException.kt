package com.mkam.essentials.exceptions.base

import com.mkam.essentials.exceptions.base.WithLocalizedMessage
import com.mkam.essentials.resources.CoreStringProvider
import com.mkam.essentials.resources.StringProviderStore

abstract class AbstractCoreAppException(
    message: String,
    cause: Throwable? = null,
) : AbstractAppException(message, cause), WithLocalizedMessage {

    override fun getLocalizedMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedMessage(stringProviderStore.get<CoreStringProvider>())
    }

    abstract fun getLocalizedMessage(stringProvider: CoreStringProvider) : String
}