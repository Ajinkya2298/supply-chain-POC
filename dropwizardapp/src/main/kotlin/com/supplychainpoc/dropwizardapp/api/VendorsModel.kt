package com.supplychainpoc.dropwizardapp.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class VendorsModel(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("fulfillmentAreas")
    var fulfillmentAreas: List<String>
)
