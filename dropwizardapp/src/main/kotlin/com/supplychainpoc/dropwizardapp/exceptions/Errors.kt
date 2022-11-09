package com.supplychainpoc.dropwizardapp.exceptions

import java.lang.Exception
import javax.ws.rs.core.Response

object Errors {
    const val PRODUCT_NOT_FOUND = "PRODUCT_NOT_FOUND_ERROR"
    const val UNIT_NOT_FOUND = "UNIT_NOT_FOUND_ERROR"
    const val NO_SUCH_VENDOR_PRODUCT_FOUND = "NO_SUCH_VENDOR_PRODUCT_FOUND"
    const val NO_SUCH_VENDOR_FOUND = "NO_SUCH_VENDOR_FOUND_ERROR"

    fun generateExceptionResponse(e: Exception): Response {
        return when (e.message) {
            PRODUCT_NOT_FOUND -> {
                Response.status(Response.Status.NOT_FOUND).entity(e.toString()).build()
            }
            UNIT_NOT_FOUND -> {
                Response.status(Response.Status.NOT_FOUND).entity(e.toString()).build()
            }
            NO_SUCH_VENDOR_PRODUCT_FOUND -> {
                Response.status(Response.Status.NOT_FOUND).entity(e.toString()).build()
            }
            NO_SUCH_VENDOR_FOUND -> {
                Response.status(Response.Status.NOT_FOUND).entity(e.toString()).build()
            }
            else -> {
                Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build()
            }
        }
    }
}

