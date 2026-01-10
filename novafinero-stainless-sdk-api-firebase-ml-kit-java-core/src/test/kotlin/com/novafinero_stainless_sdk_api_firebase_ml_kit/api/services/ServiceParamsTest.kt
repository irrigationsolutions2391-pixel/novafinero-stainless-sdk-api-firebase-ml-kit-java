// File generated from our OpenAPI spec by Stainless.

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.client.NovafineroStainlessSdkApiFirebaseMlKitClient
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.client.okhttp.NovafineroStainlessSdkApiFirebaseMlKitOkHttpClient
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.models.Order
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.models.store.StoreListInventoryParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: NovafineroStainlessSdkApiFirebaseMlKitClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            NovafineroStainlessSdkApiFirebaseMlKitOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun listInventory() {
        val storeService = client.store()
        stubFor(get(anyUrl()).willReturn(ok("{}")))

        storeService.listInventory(
            StoreListInventoryParams.builder()
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            getRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val orderService = client.store().orders()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        orderService.create(
            Order.builder()
                .id(10L)
                .complete(true)
                .petId(198772L)
                .quantity(7)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Order.Status.APPROVED)
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }
}
