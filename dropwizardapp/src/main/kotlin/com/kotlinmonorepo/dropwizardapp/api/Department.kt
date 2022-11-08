package com.kotlinmonorepo.dropwizardapp.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

class Department (
    @JsonProperty("id")
    val id: UUID,
    @JsonProperty("name")
    val name: String,
)
