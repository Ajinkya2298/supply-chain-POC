package com.kotlinmonorepo.jdbi.dao

import com.kotlinmonorepo.model.DepartmentModel
import com.kotlinmonorepo.jdbi.entities.DepartmentEntity
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

@UseClasspathSqlLocator
interface DepartmentDao {
    @SqlQuery
    fun insert(@BindBean department: DepartmentModel): DepartmentEntity

    @SqlQuery
    fun list(): List<DepartmentEntity>
}
