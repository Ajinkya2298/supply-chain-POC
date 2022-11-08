package com.kotlinmonorepo.dropwizardapp.resources

import com.codahale.metrics.annotation.Timed
import com.kotlinmonorepo.dropwizardapp.entities.PingEntity
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/ping")
class PingResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun default(): Response {
        val message = PingEntity(null)
        return Response.ok().entity(message).build()
    }
}
