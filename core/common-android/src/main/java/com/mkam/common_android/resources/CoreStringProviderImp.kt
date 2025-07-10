package com.mkam.common_android.resources

import android.content.Context
import com.mkam.common_android.R
import com.mkam.essentials.resources.CoreStringProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CoreStringProviderImp @Inject constructor(
    @ApplicationContext private val context: Context,
) : CoreStringProvider {

    override val connectionErrorMessage: String
        get() = context.getString(R.string.connection_error)

    override val unknownErrorMessage: String
        get() = context.getString(R.string.unknown_error)
}