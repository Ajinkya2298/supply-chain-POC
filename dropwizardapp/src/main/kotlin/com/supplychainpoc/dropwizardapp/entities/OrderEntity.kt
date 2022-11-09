package com.supplychainpoc.dropwizardapp.entities

import com.supplychainpoc.dropwizardapp.api.OrderProduct
import com.supplychainpoc.dropwizardapp.enums.OrderStatus
import java.util.*

data class OrderEntity(
    val id: UUID,
    val vendorId: UUID,
    val muid: UUID,
    val products: List<OrderProduct>,
    var status: OrderStatus
)
