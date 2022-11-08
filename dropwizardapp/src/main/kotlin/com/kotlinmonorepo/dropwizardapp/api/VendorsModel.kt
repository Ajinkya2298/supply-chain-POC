package com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*


data class VendorsModel (
    @JsonProperty("name")
    val name: String,
    @JsonProperty("fulfillmentAreas")
    var fulfillmentAreas: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VendorsModel

        if (name != other.name) return false
        if (!fulfillmentAreas.contentEquals(other.fulfillmentAreas)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + fulfillmentAreas.contentHashCode()
        return result
    }
}
