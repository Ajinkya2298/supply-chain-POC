package com.kotlinmonorepo.guice

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.kotlinmonorepo.service.DepartmentService
import com.kotlinmonorepo.service.DepartmentServiceImpl

class ServiceModule : AbstractModule() {
    override fun configure() {
        bind(DepartmentService::class.java).to(DepartmentServiceImpl::class.java)
        bind(DepartmentServiceImpl::class.java).`in`(Singleton::class.java)
    }
}
