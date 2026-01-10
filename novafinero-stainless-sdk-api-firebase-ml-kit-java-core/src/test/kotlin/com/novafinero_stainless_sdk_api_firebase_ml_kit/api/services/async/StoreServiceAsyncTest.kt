// File generated from our OpenAPI spec by Stainless.

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.async

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.TestServerExtension
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.client.okhttp.NovafineroStainlessSdkApiFirebaseMlKitOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StoreServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun listInventory() {
        val client =
            NovafineroStainlessSdkApiFirebaseMlKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val storeServiceAsync = client.store()

        val responseFuture = storeServiceAsync.listInventory()

        val response = responseFuture.get()
        response.validate()
    }
}
