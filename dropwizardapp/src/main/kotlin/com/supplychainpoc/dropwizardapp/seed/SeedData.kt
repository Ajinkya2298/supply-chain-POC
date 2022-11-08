package com.supplychainpoc.dropwizardapp.seed

import com.supplychainpoc.dropwizardapp.entities.Product
import com.supplychainpoc.dropwizardapp.entities.ProductType
import com.supplychainpoc.dropwizardapp.entities.Unit
import java.util.*

object SeedData {

    // product types
    val dairy = ProductType(
        id = UUID.fromString("d02126e0-5105-4976-89a0-3c3f835dc933"),
        name = "Dairy"
    )
    val poultry = ProductType(
        id = UUID.fromString("50b958b5-202a-4b5d-aaf4-1ed5aa362a2a"),
        name = "Poultry"
    )

    // Products
    val skimmedMilk = Product(
        id = UUID.fromString("ba45c588-5d2b-428d-a18d-b2fa603ed2a2"),
        name = "Skimmed Milk",
        type = "PT_Dairy"
    )
    val eggs = Product(
        id = UUID.fromString("12dd3812-04e2-4c28-8624-596ee900eff8"),
        name = "Skimmed Milk",
        type = "PT_Poultry"
    )

    // list of products
    val products = mutableSetOf(skimmedMilk, eggs)

    // Unit
    private val unit1 = Unit(
        id = UUID.fromString("f37adecc-f3f9-4415-86b2-bf2b4096a937"),
        name = "OUNCE",
        symbol = "OZ"
    )
    private val unit2 = Unit(
        id = UUID.fromString("868a3cfb-6ec9-4640-9013-c15fdac3841d"),
        name = "KILO",
        symbol = "KG"
    )

    // list of units
    val units = mutableSetOf(unit1, unit2)
}
