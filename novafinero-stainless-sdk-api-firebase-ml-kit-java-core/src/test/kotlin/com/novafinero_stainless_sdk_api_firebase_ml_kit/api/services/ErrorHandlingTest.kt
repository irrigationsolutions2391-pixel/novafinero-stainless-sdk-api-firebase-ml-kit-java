// File generated from our OpenAPI spec by Stainless.

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.client.NovafineroStainlessSdkApiFirebaseMlKitClient
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.client.okhttp.NovafineroStainlessSdkApiFirebaseMlKitOkHttpClient
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.JsonValue
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.http.Headers
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.jsonMapper
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.BadRequestException
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.InternalServerException
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.NotFoundException
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.NovafineroStainlessSdkApiFirebaseMlKitException
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.PermissionDeniedException
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.RateLimitException
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.UnauthorizedException
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.UnexpectedStatusCodeException
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.errors.UnprocessableEntityException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: NovafineroStainlessSdkApiFirebaseMlKitClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            NovafineroStainlessSdkApiFirebaseMlKitOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun storeListInventory400() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<BadRequestException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory400WithRawResponse() {
        val storeService = client.store().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<BadRequestException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory401() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<UnauthorizedException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory401WithRawResponse() {
        val storeService = client.store().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<UnauthorizedException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory403() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<PermissionDeniedException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory403WithRawResponse() {
        val storeService = client.store().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<PermissionDeniedException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory404() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<NotFoundException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory404WithRawResponse() {
        val storeService = client.store().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<NotFoundException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory422() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<UnprocessableEntityException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory422WithRawResponse() {
        val storeService = client.store().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<UnprocessableEntityException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory429() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<RateLimitException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory429WithRawResponse() {
        val storeService = client.store().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<RateLimitException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory500() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<InternalServerException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory500WithRawResponse() {
        val storeService = client.store().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<InternalServerException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory999() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<UnexpectedStatusCodeException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventory999WithRawResponse() {
        val storeService = client.store().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e = assertThrows<UnexpectedStatusCodeException> { storeService.listInventory() }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun storeListInventoryInvalidJsonBody() {
        val storeService = client.store()
        stubFor(
            get(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<NovafineroStainlessSdkApiFirebaseMlKitException> {
                storeService.listInventory()
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
