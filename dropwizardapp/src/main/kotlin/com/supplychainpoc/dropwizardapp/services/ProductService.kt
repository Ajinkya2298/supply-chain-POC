package com.supplychainpoc.dropwizardapp.services

import com.supplychainpoc.dropwizardapp.entities.Product
import com.supplychainpoc.dropwizardapp.exceptions.CustomException
import com.supplychainpoc.dropwizardapp.exceptions.Errors
import com.supplychainpoc.dropwizardapp.seed.SeedData
import java.util.UUID

object ProductService {
    private val products: MutableSet<Product> = SeedData.products

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun getProductById(id: UUID): Product {
        products.forEach {
            if (it.id == id) {
                return it
            }
        }
        throw CustomException(Errors.PRODUCT_NOT_FOUND)
    }
}
