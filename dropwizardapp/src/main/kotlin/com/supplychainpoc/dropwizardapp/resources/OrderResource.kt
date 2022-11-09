package com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.resources

import com.codahale.metrics.annotation.Timed
import com.supplychainpoc.dropwizardapp.api.OrderModel
import com.supplychainpoc.dropwizardapp.enums.OrderStatus
import com.supplychainpoc.dropwizardapp.exceptions.Errors
import com.supplychainpoc.dropwizardapp.services.OrderService
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.PATCH
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/orders")
class OrderResource {

    private val orderService: OrderService = OrderService

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun create(
        order: OrderModel
    ): Response {
        val created = orderService.create(order)
        return Response.status(Response.Status.CREATED).entity(created).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun list(): Response {
        return Response.ok().entity(orderService.list()).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun get(
        @PathParam("id")
        id: UUID,
    ): Response {
        val order = orderService.get(id)
        return if (order != null) {
            Response.ok().entity(order).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @PATCH
    @Path("/{id}/{status}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun update(
        @PathParam("id")
        id: UUID,
        @PathParam("status")
        status: OrderStatus
    ): Response {
        return try {
            val updateStatus2 = orderService.updateStatus2(id, status)
            Response.status(Response.Status.OK).entity(updateStatus2).build()
        } catch (e: Exception) {
            Errors.generateExceptionResponse(e)
        }
    }
}
