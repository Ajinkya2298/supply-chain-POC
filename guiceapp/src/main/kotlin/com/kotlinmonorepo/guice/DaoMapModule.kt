package com.kotlinmonorepo.guice

import com.google.inject.Provides
import com.google.inject.Singleton
import com.kotlinmonorepo.jdbi.dao.DepartmentDao
import dev.misfitlabs.kotlinguice4.KotlinModule
import org.jdbi.v3.core.Jdbi

class DaoMapModule : KotlinModule() {

    override fun configure() {}

    @Singleton
    @Provides
    fun providesDepartmentDao(jdbi: Jdbi): DepartmentDao {
        return jdbi.onDemand(DepartmentDao::class.java)
    }
}
