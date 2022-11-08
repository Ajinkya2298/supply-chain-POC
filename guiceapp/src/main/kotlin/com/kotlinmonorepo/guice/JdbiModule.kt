package com.kotlinmonorepo.guice

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.google.inject.Singleton
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.postgres.PostgresPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin
import java.util.Properties

class JdbiModule : AbstractModule() {
    @Provides
    @Singleton
    fun providesJdbi(): Jdbi {
        val props = Properties()
        props.setProperty("user", "postgres")
        return Jdbi.create("jdbc:postgresql://localhost:5432/kotlin_monorepo", props)
            .installPlugin(PostgresPlugin())
            .installPlugin(KotlinPlugin())
            .installPlugin(KotlinSqlObjectPlugin())
    }
}
