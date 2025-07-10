package com.mkam.domain

import com.mkam.essentials.resources.StringProvider

interface AuthStringProvider : StringProvider {

    val deviceIsRootedErrorMessage: String

}