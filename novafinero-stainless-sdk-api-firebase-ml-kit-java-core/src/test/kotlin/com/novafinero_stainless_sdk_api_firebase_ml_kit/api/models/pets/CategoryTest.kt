// File generated from our OpenAPI spec by Stainless.

package com.novafinero_stainless_sdk_api_firebase_ml_kit.api.models.pets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.novafinero_stainless_sdk_api_firebase_ml_kit.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CategoryTest {

    @Test
    fun create() {
        val category = Category.builder().id(1L).name("Dogs").build()

        assertThat(category.id()).contains(1L)
        assertThat(category.name()).contains("Dogs")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val category = Category.builder().id(1L).name("Dogs").build()

        val roundtrippedCategory =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(category),
                jacksonTypeRef<Category>(),
            )

        assertThat(roundtrippedCategory).isEqualTo(category)
    }
}
