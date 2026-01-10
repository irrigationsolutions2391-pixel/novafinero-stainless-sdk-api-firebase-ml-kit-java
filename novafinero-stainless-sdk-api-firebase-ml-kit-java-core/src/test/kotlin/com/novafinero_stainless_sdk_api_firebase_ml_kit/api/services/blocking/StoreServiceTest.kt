// File generated from our OpenAPI spec by Stainless.

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services.blocking

import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.TestServerExtension
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.client.okhttp.NovafineroStainlessSdkApiFirebaseMlKitOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StoreServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun listInventory() {
        val client =
            NovafineroStainlessSdkApiFirebaseMlKitOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val storeService = client.store()

        val response = storeService.listInventory()

        response.validate()
    }
}
