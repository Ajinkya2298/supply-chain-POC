package com.kotlinmonorepo

import com.kotlinmonorepo.jdbi.dao.DepartmentDao
import com.kotlinmonorepo.jdbi.entities.DepartmentEntity
import com.kotlinmonorepo.model.DepartmentModel
import java.util.UUID

class DepartmentDaoMock : DepartmentDao {

    private val departments = mutableListOf<DepartmentEntity>()

    override fun insert(department: DepartmentModel): DepartmentEntity {
        val departmentEntity = DepartmentEntity(UUID.randomUUID(), department.name)
        departments.add(departmentEntity)
        return departmentEntity
    }

    override fun list(): List<DepartmentEntity> {
        return departments
    }
}
