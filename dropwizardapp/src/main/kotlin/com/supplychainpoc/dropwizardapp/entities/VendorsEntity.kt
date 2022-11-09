package com.supplychainpoc.dropwizardapp.entities

import com.supplychainpoc.dropwizardapp.api.VendorsModel
import java.util.*

data class VendorsEntity(
    val id: UUID,
    var name: String,
    var fulfillmentAreas: List<String>
) {
    fun update(vendor: VendorsModel) {
        this.name = vendor.name
        this.fulfillmentAreas = vendor.fulfillmentAreas
    }
}
