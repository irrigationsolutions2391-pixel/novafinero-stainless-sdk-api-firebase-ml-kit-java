@file:JvmName("JsonHandler")

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.HttpResponse
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.HttpResponse.Handler
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.NovafineroStainlessSdkApiFirebaseMlKitInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw NovafineroStainlessSdkApiFirebaseMlKitInvalidDataException(
                    "Error reading response",
                    e,
                )
            }
    }
