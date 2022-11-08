package com.supplychainpoc.dropwizardapp.seed

import com.supplychainpoc.dropwizardapp.entities.Product
import com.supplychainpoc.dropwizardapp.entities.ProductType
import com.supplychainpoc.dropwizardapp.entities.Unit

object SeedData {

    // product types
    val dairy = ProductType("PT_Dairy", "Dairy")
    val poultry = ProductType("PT_Poultry", "Poultry")

    // Products
    val skimmedMilk = Product("P_SkimmedMilk", "Skimmed Milk", "PT_Dairy")
    val eggs = Product("P_Eggs", "Skimmed Milk", "PT_Poultry")

    // list of products
    val products = mutableSetOf(skimmedMilk, eggs)

    // Unit
    val unit1 = Unit("U_1", "OUNCE", "OZ")
    val unit2 = Unit("U_2", "KILO", "KG")

    // list of units
    val units = mutableSetOf(unit1, unit2)


}
