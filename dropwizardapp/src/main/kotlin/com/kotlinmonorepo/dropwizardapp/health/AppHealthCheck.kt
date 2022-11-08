package com.kotlinmonorepo.dropwizardapp.health

import com.codahale.metrics.health.HealthCheck

class AppHealthCheck : HealthCheck() {
    override fun check(): HealthCheck.Result {
        return HealthCheck.Result.healthy()
    }
}
