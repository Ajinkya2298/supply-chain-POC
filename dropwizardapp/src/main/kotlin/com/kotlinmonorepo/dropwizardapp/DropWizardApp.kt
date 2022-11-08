package com.kotlinmonorepo.dropwizardapp

import com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.resources.VendorsResource
import com.kotlinmonorepo.dropwizardapp.health.AppHealthCheck
import com.kotlinmonorepo.dropwizardapp.resources.DepartmentResource
import com.kotlinmonorepo.dropwizardapp.resources.PingResource
import io.dropwizard.Application
import io.dropwizard.setup.Environment

fun main(args: Array<String>) {
    DropWizardApp().run(*args)
}

class DropWizardApp : Application<DropWizardAppConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DropWizardApp().run(*args)
        }
    }

    override fun run(config: DropWizardAppConfiguration, env: Environment) {
        env.healthChecks().register("default", AppHealthCheck())
        env.jersey().register(PingResource())
        env.jersey().register(DepartmentResource())
        env.jersey().register(VendorsResource())
    }

    override fun getName(): String {
        return DropWizardAppConfiguration().applicationName
    }
}
