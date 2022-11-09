package com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.services

import com.supplychainpoc.dropwizardapp.api.VendorProductModel
import com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.api.VendorProductPatchModel
import com.supplychainpoc.dropwizardapp.entities.VendorProductEntity
import com.supplychainpoc.dropwizardapp.entities.update
import com.supplychainpoc.dropwizardapp.exceptions.CustomException
import com.supplychainpoc.dropwizardapp.exceptions.Errors
import java.util.UUID

object VendorProductService {

    private val vendorsProducts = mutableListOf<VendorProductEntity>()

    fun create(vendorId: UUID, vendor: VendorProductModel): VendorProductEntity {
        val deptToCreate = VendorProductEntity(
            id = UUID.randomUUID(),
            vendorId = vendorId,
            productId = vendor.productId,
            unitId = vendor.unitId,
            price = vendor.price,
            quantity = vendor.quantity
        )
        vendorsProducts.add(deptToCreate)
        return deptToCreate
    }

    fun update(vendorProductId: UUID, vendorId: UUID, vendor: VendorProductPatchModel): VendorProductEntity {
        val vendorProductEntity = vendorsProducts.find {
            it.id == vendorProductId && it.vendorId == vendorId
        } ?: throw CustomException(Errors.NO_SUCH_VENDOR_PRODUCT_FOUND)
        vendorProductEntity.update(vendor)
        return vendorProductEntity
    }
}
