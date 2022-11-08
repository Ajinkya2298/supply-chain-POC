package com.kotlinmonorepo

import com.google.common.collect.ImmutableList
import com.google.inject.util.Modules
import com.kotlinmonorepo.guice.DaoMapMockModule
import com.kotlinmonorepo.guice.DaoMapModule
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GuiceAppTest {
    private val app = GuiceApp

    @BeforeAll
    fun beforeAll() {
        app.modulesToOverride = ImmutableList.of(Modules.override(DaoMapModule()).with(DaoMapMockModule()))
        app.init()
    }

    @Test
    fun `Test GuiceApp`() {
        app.start()
    }
}
