package com.mkam.essentials.resources

import javax.inject.Inject
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class StringProviderStore @Inject constructor(
    @PublishedApi
    internal val stringProviders: Map<Class<*>, @JvmSuppressWildcards StringProvider>
) {

    inline fun <reified T : StringProvider> get(): T {
        return stringProviders[T::class.java] as T
    }
}