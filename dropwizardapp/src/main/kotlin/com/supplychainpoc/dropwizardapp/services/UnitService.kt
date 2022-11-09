package com.supplychainpoc.dropwizardapp.services

import com.supplychainpoc.dropwizardapp.entities.Unit
import com.supplychainpoc.dropwizardapp.exceptions.CustomException
import com.supplychainpoc.dropwizardapp.exceptions.Errors
import com.supplychainpoc.dropwizardapp.seed.SeedData

object UnitService {
    private val units = SeedData.units

    fun findBySymbol(symbol: String): Unit { // ktlint-disable no-unit-return
        units.forEach {
            if (it.symbol == symbol) {
                return it
            }
        }
        throw CustomException(Errors.UNIT_NOT_FOUND)
    }
}
