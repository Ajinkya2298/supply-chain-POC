package com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.services.masterdata

import com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.entities.Product
import com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.entities.ProductType


class ProductService {
    private val skimmedMilk = Product("P_SkimmedMilk","Skimmed Milk",ProductTypeService.dairy)
    private val eggs = Product("P_Eggs","Skimmed Milk",ProductTypeService.poultry)
    private val products = mutableListOf<Product>(skimmedMilk,eggs)
}
