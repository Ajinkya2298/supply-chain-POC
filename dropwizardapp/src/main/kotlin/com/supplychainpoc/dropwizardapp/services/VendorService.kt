
package com.supplychainpoc.dropwizardapp.services

import com.supplychainpoc.dropwizardapp.api.VendorsModel
import com.supplychainpoc.dropwizardapp.entities.VendorsEntity
import com.supplychainpoc.dropwizardapp.entities.update
import com.supplychainpoc.dropwizardapp.exceptions.CustomException
import com.supplychainpoc.dropwizardapp.exceptions.Errors
import java.util.*

object VendorService : IVendor {
    private val vendors = mutableListOf<VendorsEntity>()

    override fun create(vendor: VendorsModel): VendorsEntity {
        val deptToCreate = VendorsEntity(UUID.randomUUID(), vendor.name, vendor.fulfillmentAreas)
        vendors.add(deptToCreate)
        return deptToCreate
    }

    override fun list(): List<VendorsEntity> {
        return vendors
    }

    override fun get(id: UUID): VendorsEntity? {
        return vendors.find { vendor -> vendor.id == id }
    }

    override fun update(id: UUID, department: VendorsModel): Boolean {
        var updated = false
        val index = vendors.indexOfFirst { vendor -> vendor.id == id }
        if (index > -1) {
            vendors[index].name = department.name
            vendors[index].fulfillmentAreas = department.fulfillmentAreas
            updated = true
        }
        return updated
    }

    override fun update2(id: UUID, vendor: VendorsModel): VendorsEntity {
        val vendorEntity = vendors.find {
            it.id == id
        } ?: throw CustomException(Errors.NO_SUCH_VENDOR_FOUND)
        vendorEntity.update(vendor)
        return vendorEntity
    }
}
