package com.kotlinmonorepo.dropwizardapp.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlinmonorepo.dropwizardapp.api.Department
import com.kotlinmonorepo.dropwizardapp.api.DepartmentModel
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport
import io.dropwizard.testing.junit5.ResourceExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import javax.ws.rs.client.Entity

@ExtendWith(DropwizardExtensionsSupport::class)
class DepartmentResourceTest {

    private val EXT = ResourceExtension.builder().addResource(DepartmentResource()).build()
    private val objectMapper = ObjectMapper()

    @Test
    fun create() {
        val resp = EXT.target("/departments").request().post(Entity.json(DepartmentModel("Test Department")))
        val department =  objectMapper.readValue(resp.readEntity(String::class.java), Department::class.java)
        assertThat(resp.status).isEqualTo(201)
        assertThat(department.name).isEqualTo("Test Department")
    }

    @Test
    fun list() {
        val resp = EXT.target("/departments").request().get()
        assertThat(resp.status).isEqualTo(200)
    }

    @Test
    fun get() {
        val createResp = EXT.target("/departments").request().post(Entity.json(DepartmentModel("Test Department 2")))
        val departmentCreated =  objectMapper.readValue(createResp.readEntity(String::class.java), Department::class.java)
        val resp = EXT.target("/departments/${departmentCreated.id}").request().get()
        val department =  objectMapper.readValue(resp.readEntity(String::class.java), Department::class.java)
        assertThat(resp.status).isEqualTo(200)
        assertThat(department.name).isEqualTo("Test Department 2")
    }

    @Test
    fun update() {
        val createResp = EXT.target("/departments").request().post(Entity.json(DepartmentModel("Test Department 3")))
        val departmentCreated =  objectMapper.readValue(createResp.readEntity(String::class.java), Department::class.java)
        val resp = EXT.target("/departments/${departmentCreated.id}").request()
            .method("PATCH", Entity.json(DepartmentModel("Test-Department-3")))
        val getResp = EXT.target("/departments/${departmentCreated.id}").request().get()
        val department =  objectMapper.readValue(getResp.readEntity(String::class.java), Department::class.java)
        assertThat(resp.status).isEqualTo(204)
        assertThat(department.name).isEqualTo("Test-Department-3")
    }

    @Test
    fun delete() {
        val createResp = EXT.target("/departments").request().post(Entity.json(DepartmentModel("Test Department 4")))
        val departmentCreated =  objectMapper.readValue(createResp.readEntity(String::class.java), Department::class.java)
        val resp = EXT.target("/departments/${departmentCreated.id}").request().delete()
        val getResp = EXT.target("/departments/${departmentCreated.id}").request().get()
        assertThat(resp.status).isEqualTo(204)
        assertThat(getResp.status).isEqualTo(404)
    }
}
