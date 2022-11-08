package com.supplychainpoc.dropwizardapp.entities

import com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.api.VendorProductPatchModel
import java.util.UUID

data class VendorProductEntity(
    val id: UUID,
    val vendorId: UUID,
    val productId: UUID,
    val unitId: UUID,
    var price: Double,
    var quantity: Long
)

fun VendorProductEntity.update(vendorProductModel: VendorProductPatchModel) {
    if (vendorProductModel.price != null) {
        this.price = vendorProductModel.price
    }
    if (vendorProductModel.quantity != null) {
        this.quantity = vendorProductModel.quantity
    }
}
