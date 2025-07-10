package com.mkam.essentials.exceptions.mapper

import com.mkam.essentials.exceptions.base.WithLocalizedMessage
import com.mkam.essentials.resources.CoreStringProvider
import com.mkam.essentials.resources.StringProviderStore
import javax.inject.Inject

class DefaultExceptionToMessageMapper @Inject constructor(
    private val stringProviderStore: StringProviderStore
) : ExceptionToMessageMapper {

    override fun getLocalizedMessage(exception: Exception): String {
        return if (exception is WithLocalizedMessage){
            exception.getLocalizedMessage(stringProviderStore)
        }else{
            stringProviderStore.get<CoreStringProvider>().unknownErrorMessage
        }
    }
}