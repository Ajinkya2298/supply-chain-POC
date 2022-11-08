package com.supplychainpoc.dropwizardapp.resources

import com.codahale.metrics.annotation.Timed
import com.supplychainpoc.dropwizardapp.api.VendorsModel
import com.supplychainpoc.dropwizardapp.services.VendorService
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/vendors")
class VendorsResource {

    private val vendorService: VendorService = VendorService()

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
    ):Response {
        return if(vendorService.update(id,vendor))
            Response.status(Response.Status.OK).entity("Updated Successfully!").build()
        else Response.status(Response.Status.NOT_FOUND).build()

    }
}
