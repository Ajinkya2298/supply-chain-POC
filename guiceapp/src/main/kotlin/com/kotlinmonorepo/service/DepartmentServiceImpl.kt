package com.kotlinmonorepo.service

import com.google.inject.Inject
import com.kotlinmonorepo.jdbi.dao.DepartmentDao
import com.kotlinmonorepo.model.DepartmentModel
import com.kotlinmonorepo.jdbi.entities.DepartmentEntity

class DepartmentServiceImpl @Inject constructor(
    private val departmentDao: DepartmentDao,
) : DepartmentService {
    override fun create(department: DepartmentModel): DepartmentEntity {
        return departmentDao.insert(department)
    }

    override fun findAll(): List<DepartmentEntity> {
        return departmentDao.list()
    }
}
