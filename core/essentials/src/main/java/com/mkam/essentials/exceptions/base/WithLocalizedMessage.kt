package com.mkam.essentials.exceptions.base

import com.mkam.essentials.resources.StringProviderStore

interface WithLocalizedMessage {

    fun getLocalizedMessage(stringProviderStore: StringProviderStore): String

}