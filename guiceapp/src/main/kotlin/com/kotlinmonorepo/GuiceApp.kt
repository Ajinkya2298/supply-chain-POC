package com.kotlinmonorepo

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.google.inject.Module
import com.google.inject.util.Modules
import com.kotlinmonorepo.guice.DaoMapModule
import com.kotlinmonorepo.guice.JdbiModule
import com.kotlinmonorepo.guice.ServiceModule
import com.kotlinmonorepo.model.DepartmentModel
import com.kotlinmonorepo.service.DepartmentService

fun main(args: Array<String>) {
    GuiceApp.main(args)
}

class GuiceApp {
    companion object {
        lateinit var modules: ImmutableList<Module>
        var modulesToOverride: ImmutableList<Module>? = null

        @JvmStatic
        fun main(args: Array<String>) {
            init()
            start()
        }

        @JvmStatic
        fun init() {
            println("Starting Guice App")
            modules = if (modulesToOverride != null) {
                ImmutableList.of(Modules.override(listOf(
                    JdbiModule(),
                    DaoMapModule(),
                    ServiceModule()
                )).with((modulesToOverride)))
            } else {
                ImmutableList.of(
                    JdbiModule(),
                    DaoMapModule(),
                    ServiceModule()
                )
            }
        }

        @JvmStatic
        fun start() {
            val injector = Guice.createInjector(modules)
            injector.injectMembers(this)
            val departmentService = injector.getInstance(DepartmentService::class.java)
            departmentService.create(DepartmentModel("FinTech"))
            departmentService.create(DepartmentModel("Platform"))
            departmentService.create(DepartmentModel("Data Science"))
            println("Created departments:")
            println(departmentService.findAll())
        }
    }
}
