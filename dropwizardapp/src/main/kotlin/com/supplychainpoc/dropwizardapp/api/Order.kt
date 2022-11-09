package com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.api

import com.fasterxml.jackson.annotation.JsonProperty
import com.supplychainpoc.dropwizardapp.api.OrderProduct
import com.supplychainpoc.dropwizardapp.enums.OrderStatus
import java.util.*

data class Order (
    @JsonProperty("id")
    val id: UUID,
    @JsonProperty("vendorId")
    val vendorId: UUID,
    @JsonProperty("muid")
    val muid: UUID,
    @JsonProperty("products")
    val products: List<OrderProduct>,
    @JsonProperty("status")
    val status: OrderStatus
)
