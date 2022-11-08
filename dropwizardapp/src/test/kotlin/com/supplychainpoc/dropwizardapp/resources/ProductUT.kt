package com.supplychainpoc.dropwizardapp.resources

import com.supplychainpoc.dropwizardapp.exceptions.CustomException
import com.supplychainpoc.dropwizardapp.exceptions.Errors
import com.supplychainpoc.dropwizardapp.seed.SeedData
import com.supplychainpoc.dropwizardapp.services.ProductService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProductUT {

    @Test
    fun `get product by valid id`() {
        val productService = ProductService()
        val productById = productService.getProductById("P_SkimmedMilk")

        Assertions.assertEquals(productById.id, SeedData.skimmedMilk.id)
        Assertions.assertEquals(productById.name, SeedData.skimmedMilk.name)
        Assertions.assertEquals(productById.type, SeedData.skimmedMilk.type)
    }

    @Test
    fun `get product by invalid id`() {
        val productService = ProductService()

        val assertThrows = assertThrows<CustomException> {
            productService.getProductById("NotThere")
        }

        Assertions.assertEquals(assertThrows.message, Errors.PRODUCT_NOT_FOUND)
    }
}