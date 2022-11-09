package com.supplychainpoc.dropwizardapp.enums

enum class OrderStatus (val type: String) {
    RECEIVED("RECEIVED"),
    READY_FOR_SHIPMENT("READY_FOR_SHIPMENT"),
    OUT_FOR_DELIVERY("OUT_FOR_DELIVERY"),
    DELIVERED("DELIVERED")
}
