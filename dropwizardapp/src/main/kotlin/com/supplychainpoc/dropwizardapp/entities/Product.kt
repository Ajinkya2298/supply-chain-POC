package com.supplychainpoc.dropwizardapp.entities

import java.util.UUID

data class Product(
    val id: UUID,
    var name: String,
    val type: String
)
