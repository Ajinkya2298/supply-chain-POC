package com.supplychainpoc.dropwizardapp.core.dao

import com.supplychainpoc.dropwizardapp.api.DepartmentModel
import com.supplychainpoc.dropwizardapp.entities.DepartmentEntity
import java.util.UUID

interface DepartmentDao {
    fun create(department: DepartmentModel): DepartmentEntity
    fun list() : List<DepartmentEntity>
    fun get(id: UUID) : DepartmentEntity?
    fun update(id: UUID, department: DepartmentModel): Boolean
    fun delete(id: UUID) : Boolean
}
