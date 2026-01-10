// File generated from our OpenAPI spec by Stainless.

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.client

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.ClientOptions
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.getPackageVersion
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.blocking.PetService
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.blocking.PetServiceImpl
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.blocking.StoreService
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.blocking.StoreServiceImpl
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.blocking.UserService
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.blocking.UserServiceImpl
import java.util.function.Consumer

class NovafineroStainlessSdkApiFirebaseMlKitClientImpl(private val clientOptions: ClientOptions) :
    NovafineroStainlessSdkApiFirebaseMlKitClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: NovafineroStainlessSdkApiFirebaseMlKitClientAsync by lazy {
        NovafineroStainlessSdkApiFirebaseMlKitClientAsyncImpl(clientOptions)
    }

    private val withRawResponse:
        NovafineroStainlessSdkApiFirebaseMlKitClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pets: PetService by lazy { PetServiceImpl(clientOptionsWithUserAgent) }

    private val store: StoreService by lazy { StoreServiceImpl(clientOptionsWithUserAgent) }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): NovafineroStainlessSdkApiFirebaseMlKitClientAsync = async

    override fun withRawResponse(): NovafineroStainlessSdkApiFirebaseMlKitClient.WithRawResponse =
        withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): NovafineroStainlessSdkApiFirebaseMlKitClient =
        NovafineroStainlessSdkApiFirebaseMlKitClientImpl(
            clientOptions.toBuilder().apply(modifier::accept).build()
        )

    override fun pets(): PetService = pets

    override fun store(): StoreService = store

    override fun users(): UserService = users

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NovafineroStainlessSdkApiFirebaseMlKitClient.WithRawResponse {

        private val pets: PetService.WithRawResponse by lazy {
            PetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val store: StoreService.WithRawResponse by lazy {
            StoreServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NovafineroStainlessSdkApiFirebaseMlKitClient.WithRawResponse =
            NovafineroStainlessSdkApiFirebaseMlKitClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pets(): PetService.WithRawResponse = pets

        override fun store(): StoreService.WithRawResponse = store

        override fun users(): UserService.WithRawResponse = users
    }
}
