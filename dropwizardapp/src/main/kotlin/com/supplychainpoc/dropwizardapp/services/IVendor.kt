package com.supplychainpoc.dropwizardapp.services

import com.supplychainpoc.dropwizardapp.api.VendorsModel
import com.supplychainpoc.dropwizardapp.entities.VendorsEntity
import java.util.*

interface IVendor {
    fun create(vendor: VendorsModel): VendorsEntity
    fun list(): List<VendorsEntity>
    fun get(id: UUID): VendorsEntity?
    fun update(id: UUID, department: VendorsModel): Boolean
}
