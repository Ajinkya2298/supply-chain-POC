package com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.api

import com.fasterxml.jackson.annotation.JsonProperty

data class VendorProductPatchModel(
    @JsonProperty("price") val price: Double? = null,
    @JsonProperty("quantity") val quantity: Long? = null
)
