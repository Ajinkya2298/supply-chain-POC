package com.supplychainpoc.dropwizardapp.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class VendorProductModel(
    @JsonProperty("productId") val productId: UUID,
    @JsonProperty("unitId") val unitId: UUID,
    @JsonProperty("price") val price: Double,
    @JsonProperty("quantity") val quantity: Long
)