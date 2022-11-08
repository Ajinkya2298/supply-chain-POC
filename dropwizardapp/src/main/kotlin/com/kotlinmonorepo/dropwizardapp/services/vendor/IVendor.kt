package com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.services.vendor

import com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.api.VendorsModel
import com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.entities.VendorsEntity
import java.util.*


interface IVendor {
    fun create(vendor: VendorsModel): VendorsEntity
    fun list() : List<VendorsEntity>
    fun get(id: UUID) : VendorsEntity?
    fun update(id: UUID, department: VendorsModel): Boolean
}
