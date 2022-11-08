package com.kotlinmonorepo.service

import com.kotlinmonorepo.jdbi.entities.DepartmentEntity
import com.kotlinmonorepo.model.DepartmentModel

interface DepartmentService {
    fun create(department: DepartmentModel): DepartmentEntity
    fun findAll(): List<DepartmentEntity>
}
