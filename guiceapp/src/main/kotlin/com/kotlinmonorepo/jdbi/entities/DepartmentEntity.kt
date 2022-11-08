package com.kotlinmonorepo.jdbi.entities

import java.util.UUID

data class DepartmentEntity(
    val id: UUID,
    val name: String,
)
