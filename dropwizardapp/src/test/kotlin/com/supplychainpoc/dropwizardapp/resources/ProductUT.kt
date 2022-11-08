package com.supplychainpoc.dropwizardapp.resources

import com.supplychainpoc.dropwizardapp.exceptions.CustomException
import com.supplychainpoc.dropwizardapp.exceptions.Errors
import com.supplychainpoc.dropwizardapp.seed.SeedData
import com.supplychainpoc.dropwizardapp.services.ProductService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class ProductUT {

    @Test
    fun `get product by valid id`() {
        val productService = ProductService()
        val productById = productService.getProductById(SeedData.skimmedMilk.id)

        Assertions.assertEquals(productById.id, SeedData.skimmedMilk.id)
        Assertions.assertEquals(productById.name, SeedData.skimmedMilk.name)
        Assertions.assertEquals(productById.type, SeedData.skimmedMilk.type)
    }

    @Test
    fun `get product by invalid id`() {
        val productService = ProductService()

        val assertThrows = assertThrows<CustomException> {
            productService.getProductById(UUID.randomUUID())
        }

        Assertions.assertEquals(assertThrows.message, Errors.PRODUCT_NOT_FOUND)
    }
}