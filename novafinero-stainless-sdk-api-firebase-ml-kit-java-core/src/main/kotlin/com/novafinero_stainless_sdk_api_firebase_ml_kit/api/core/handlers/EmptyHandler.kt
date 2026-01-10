@file:JvmName("EmptyHandler")

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.handlers

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.HttpResponse
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
