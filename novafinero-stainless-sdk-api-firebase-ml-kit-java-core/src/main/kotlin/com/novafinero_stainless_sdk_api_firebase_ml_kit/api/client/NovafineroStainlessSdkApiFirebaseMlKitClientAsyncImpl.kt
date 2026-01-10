// File generated from our OpenAPI spec by Stainless.

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.client

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.ClientOptions
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.getPackageVersion
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.async.PetServiceAsync
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.async.PetServiceAsyncImpl
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.async.StoreServiceAsync
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.async.StoreServiceAsyncImpl
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.async.UserServiceAsync
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.async.UserServiceAsyncImpl
import java.util.function.Consumer

class NovafineroStainlessSdkApiFirebaseMlKitClientAsyncImpl(
    private val clientOptions: ClientOptions
) : NovafineroStainlessSdkApiFirebaseMlKitClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: NovafineroStainlessSdkApiFirebaseMlKitClient by lazy {
        NovafineroStainlessSdkApiFirebaseMlKitClientImpl(clientOptions)
    }

    private val withRawResponse:
        NovafineroStainlessSdkApiFirebaseMlKitClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pets: PetServiceAsync by lazy { PetServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val store: StoreServiceAsync by lazy {
        StoreServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): NovafineroStainlessSdkApiFirebaseMlKitClient = sync

    override fun withRawResponse():
        NovafineroStainlessSdkApiFirebaseMlKitClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): NovafineroStainlessSdkApiFirebaseMlKitClientAsync =
        NovafineroStainlessSdkApiFirebaseMlKitClientAsyncImpl(
            clientOptions.toBuilder().apply(modifier::accept).build()
        )

    override fun pets(): PetServiceAsync = pets

    override fun store(): StoreServiceAsync = store

    override fun users(): UserServiceAsync = users

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NovafineroStainlessSdkApiFirebaseMlKitClientAsync.WithRawResponse {

        private val pets: PetServiceAsync.WithRawResponse by lazy {
            PetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val store: StoreServiceAsync.WithRawResponse by lazy {
            StoreServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NovafineroStainlessSdkApiFirebaseMlKitClientAsync.WithRawResponse =
            NovafineroStainlessSdkApiFirebaseMlKitClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pets(): PetServiceAsync.WithRawResponse = pets

        override fun store(): StoreServiceAsync.WithRawResponse = store

        override fun users(): UserServiceAsync.WithRawResponse = users
    }
}
