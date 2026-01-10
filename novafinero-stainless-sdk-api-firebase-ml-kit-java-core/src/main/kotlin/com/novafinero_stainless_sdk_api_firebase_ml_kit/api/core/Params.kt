package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.Headers
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.QueryParams

/** An interface representing parameters passed to a service method. */
interface Params {
    /** The full set of headers in the parameters, including both fixed and additional headers. */
    fun _headers(): Headers

    /**
     * The full set of query params in the parameters, including both fixed and additional query
     * params.
     */
    fun _queryParams(): QueryParams
}
