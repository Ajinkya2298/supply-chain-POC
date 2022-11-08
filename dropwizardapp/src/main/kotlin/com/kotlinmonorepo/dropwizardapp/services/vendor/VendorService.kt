<<<<<<<< HEAD:dropwizardapp/src/main/kotlin/com/supplychainpoc/dropwizardapp/services/VendorService.kt
package com.supplychainpoc.dropwizardapp.services
========
package com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.services.vendor
>>>>>>>> fee2f33 (added master data):dropwizardapp/src/main/kotlin/com/kotlinmonorepo/dropwizardapp/services/vendor/VendorService.kt

import com.supplychainpoc.dropwizardapp.api.VendorsModel
import com.supplychainpoc.dropwizardapp.entities.VendorsEntity
import java.util.*


class VendorService : IVendor {
    private val vendors = mutableListOf<VendorsEntity>()

    override fun create(vendor: VendorsModel): VendorsEntity {
        val deptToCreate = VendorsEntity(UUID.randomUUID(), vendor.name,vendor.fulfillmentAreas)
        vendors.add(deptToCreate)
        return deptToCreate
    }

    override fun list(): List<VendorsEntity> {
        return vendors
    }

    override fun get(id: UUID): VendorsEntity? {
        return vendors.find { vendor -> vendor.id == id }
    }

    override fun update(id: UUID, updatedVendor: VendorsModel): Boolean {
        var updated = false
        val index = vendors.indexOfFirst { vendor -> vendor.id == id }
        if (index > -1) {
            vendors[index].name = updatedVendor.name
            vendors[index].fulfillmentAreas = updatedVendor.fulfillmentAreas
            updated = true
        }
        return updated
    }

}
