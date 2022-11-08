package com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.entities

import java.util.*


data class VendorsEntity(
    val id: UUID,
    var name: String,
    var fulfillmentAreas:List<String>
)
