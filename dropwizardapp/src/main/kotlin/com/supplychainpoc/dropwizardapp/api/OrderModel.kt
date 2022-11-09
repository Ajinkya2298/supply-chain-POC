package com.supplychainpoc.dropwizardapp.api

import com.fasterxml.jackson.annotation.JsonProperty
import com.supplychainpoc.dropwizardapp.enums.OrderStatus
import java.util.*

data class OrderProduct (
    @JsonProperty("vendorProductId")
    val vendorProductId: UUID,
    @JsonProperty("quantity")
    val quantity: Int
)

data class OrderModel (
    @JsonProperty("vendorId")
    val vendorId: UUID,
    @JsonProperty("muid")
    val muid: UUID,
    @JsonProperty("products")
    val products: List<OrderProduct>
)
