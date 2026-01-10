@file:JvmName("PrepareRequest")

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.HttpRequest
import java.util.concurrent.CompletableFuture

@JvmSynthetic
internal fun HttpRequest.prepare(clientOptions: ClientOptions, params: Params): HttpRequest =
    toBuilder()
        .putAllQueryParams(clientOptions.queryParams)
        .replaceAllQueryParams(params._queryParams())
        .putAllHeaders(clientOptions.headers)
        .replaceAllHeaders(params._headers())
        .build()

@JvmSynthetic
internal fun HttpRequest.prepareAsync(
    clientOptions: ClientOptions,
    params: Params,
): CompletableFuture<HttpRequest> =
    // This async version exists to make it easier to add async specific preparation logic in the
    // future.
    CompletableFuture.completedFuture(prepare(clientOptions, params))
