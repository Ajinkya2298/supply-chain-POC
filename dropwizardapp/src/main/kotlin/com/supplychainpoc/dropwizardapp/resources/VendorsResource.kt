package com.supplychainpoc.dropwizardapp.resources

import com.codahale.metrics.annotation.Timed
import com.supplychainpoc.dropwizardapp.api.VendorProductModel
import com.supplychainpoc.dropwizardapp.api.VendorsModel
import com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.api.VendorProductPatchModel
import com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.services.VendorProductService
import com.supplychainpoc.dropwizardapp.exceptions.Errors
import com.supplychainpoc.dropwizardapp.services.VendorService
import java.lang.Exception
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

const val FF_RESOURCE = true

@Path("/vendors")
class VendorsResource {

    private val vendorService: VendorService = VendorService
    private val vendorProductService = VendorProductService

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun create(
        vendor: VendorsModel
    ): Response {
        val created = vendorService.create(vendor)
        return Response.status(Response.Status.CREATED).entity(created).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun list(): Response {
        return Response.ok().entity(vendorService.list()).build()
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun update(
        @PathParam("id")
        id: UUID,
        vendor: VendorsModel
    ): Response {
        return if (FF_RESOURCE) {
            try {
                val entity = vendorService.update2(id, vendor)
                Response.status(Response.Status.OK).entity(entity).build()
            } catch (e: Exception) {
                Errors.generateExceptionResponse(e)
            }
        } else {
            if (vendorService.update(id, vendor)) {
                Response.status(Response.Status.OK).entity("Updated Successfully!").build()
            } else Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @POST
    @Path("/{vendorId}/product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun createVendorProduct(
        @PathParam("vendorId") vendorId: UUID,
        vender: VendorProductModel
    ): Response {
        return try {
            val res = vendorProductService.create(vendorId, vender)
            return Response.status(Response.Status.OK).entity(res).build()
        } catch (e: Exception) {
            Errors.generateExceptionResponse(e)
        }
    }

    @PATCH
    @Path("/{vendorId}/product/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun updateVendorProduct(
        @PathParam("vendorId") vendorId: UUID,
        @PathParam("id") vendorProductId: UUID,
        vendor: VendorProductPatchModel
    ): Response {
        return try {
            val res = vendorProductService.update(vendorProductId, vendorId, vendor)
            return Response.status(Response.Status.OK).entity(res).build()
        } catch (e: Exception) {
            Errors.generateExceptionResponse(e)
        }
    }
}
