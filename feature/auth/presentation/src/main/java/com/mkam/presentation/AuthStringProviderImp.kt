package com.mkam.presentation

import android.content.Context
import com.mkam.domain.AuthStringProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthStringProviderImp @Inject constructor(
    @ApplicationContext private val context: Context
) : AuthStringProvider {

    override val deviceIsRootedErrorMessage: String
        get() = context.getString(R.string.rooted_device_error)

}