package com.supplychainpoc.dropwizardapp.entities

import com.supplychainpoc.dropwizardapp.entities.ProductType


data class Product (
    val id: String,
    var name: String,
    val type: ProductType
)
