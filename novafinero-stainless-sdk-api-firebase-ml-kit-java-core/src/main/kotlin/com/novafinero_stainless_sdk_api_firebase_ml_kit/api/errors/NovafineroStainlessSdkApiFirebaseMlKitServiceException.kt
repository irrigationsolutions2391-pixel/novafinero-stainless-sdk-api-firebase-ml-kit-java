// File generated from our OpenAPI spec by Stainless.

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.JsonValue
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.Headers

abstract class NovafineroStainlessSdkApiFirebaseMlKitServiceException
protected constructor(message: String, cause: Throwable? = null) :
    NovafineroStainlessSdkApiFirebaseMlKitException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
