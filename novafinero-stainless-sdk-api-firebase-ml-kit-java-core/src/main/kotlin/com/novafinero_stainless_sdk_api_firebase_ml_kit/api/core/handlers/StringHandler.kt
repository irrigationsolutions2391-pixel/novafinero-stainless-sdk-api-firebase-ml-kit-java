@file:JvmName("StringHandler")

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.handlers

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.HttpResponse
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
