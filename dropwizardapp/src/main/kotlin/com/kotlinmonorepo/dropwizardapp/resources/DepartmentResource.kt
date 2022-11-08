package com.kotlinmonorepo.dropwizardapp.resources

import com.codahale.metrics.annotation.Timed
import com.kotlinmonorepo.dropwizardapp.api.DepartmentModel
import com.kotlinmonorepo.dropwizardapp.core.dao.DepartmentDao
import com.kotlinmonorepo.dropwizardapp.core.dao.DepartmentDaoImpl
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.PATCH
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/departments")
class DepartmentResource {

    private val departmentDao: DepartmentDao = DepartmentDaoImpl()

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun create(
        department: DepartmentModel
    ): Response {
        val created = departmentDao.create(department)
        return Response.status(Response.Status.CREATED).entity(created).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun list(): Response {
        return Response.ok().entity(departmentDao.list()).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    fun get(
        @PathParam("id")
        id: UUID
    ): Response {
        val department = departmentDao.get(id)
        return if (department != null) {
            Response.ok().entity(departmentDao.get(id)).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    fun update(
        @PathParam("id")
        id: UUID,
        department: DepartmentModel
    ): Response {
        val updated = departmentDao.update(id, department)
        return if (updated) {
            Response.status(Response.Status.NO_CONTENT).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    fun delete(
        @PathParam("id")
        id: UUID,
    ): Response {
        val deleted = departmentDao.delete(id)
        return if (deleted) {
            Response.status(Response.Status.NO_CONTENT).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }
}
