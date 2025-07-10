package com.mkam.essentials.resources

interface CoreStringProvider: StringProvider {

    val connectionErrorMessage: String
    val unknownErrorMessage: String

}