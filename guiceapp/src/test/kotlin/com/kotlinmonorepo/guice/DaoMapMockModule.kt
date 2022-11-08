package com.kotlinmonorepo.guice

import com.google.inject.Singleton
import com.kotlinmonorepo.DepartmentDaoMock
import com.kotlinmonorepo.jdbi.dao.DepartmentDao
import dev.misfitlabs.kotlinguice4.KotlinModule

class DaoMapMockModule : KotlinModule() {
    override fun configure() {
        bind(DepartmentDao::class.java).to(DepartmentDaoMock::class.java)
        bind(DepartmentDaoMock::class.java).`in`(Singleton::class.java)
    }
}
