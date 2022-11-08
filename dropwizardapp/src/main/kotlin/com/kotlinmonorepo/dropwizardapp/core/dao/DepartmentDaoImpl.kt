package com.kotlinmonorepo.dropwizardapp.core.dao

import com.kotlinmonorepo.dropwizardapp.api.DepartmentModel
import com.kotlinmonorepo.dropwizardapp.entities.DepartmentEntity
import java.util.UUID

class DepartmentDaoImpl : DepartmentDao {

    private val departments = mutableListOf<DepartmentEntity>()

    override fun create(department: DepartmentModel): DepartmentEntity {
        val deptToCreate = DepartmentEntity(UUID.randomUUID(), department.name)
        departments.add(deptToCreate)
        return deptToCreate
    }

    override fun list(): List<DepartmentEntity> {
        return departments
    }

    override fun get(id: UUID): DepartmentEntity? {
        return departments.find { department -> department.id == id }
    }

    override fun update(id: UUID, updatedDepartment: DepartmentModel): Boolean {
        var updated = false
        val index = departments.indexOfFirst { department -> department.id == id }
        if (index > -1) {
            departments[index].name = updatedDepartment.name
            updated = true
        }
        return updated
    }

    override fun delete(id: UUID): Boolean {
        var removed = false
        val index = departments.indexOfFirst { department -> department.id == id }
        if (index > -1) {
            departments.removeAt(index)
            removed = true
        }
        return removed
    }
}
