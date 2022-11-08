package com.supplychainpoc.dropwizardapp.entities

import java.util.UUID

data class Unit(
    val id: UUID,
    var name: String,
    val symbol: String
)
