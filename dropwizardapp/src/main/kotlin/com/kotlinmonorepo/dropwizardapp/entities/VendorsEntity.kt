package com.kotlinmonorepo.dropwizardapp.com.kotlinmonorepo.dropwizardapp.entities

import java.util.*


data class VendorsEntity(
    val id: UUID,
    var name: String,
    var fulfillmentAreas:Array<String>

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VendorsEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (!fulfillmentAreas.contentEquals(other.fulfillmentAreas)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + fulfillmentAreas.contentHashCode()
        return result
    }
}
