package com.supplychainpoc.dropwizardapp.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.supplychainpoc.dropwizardapp.api.OrderModel
import com.supplychainpoc.dropwizardapp.api.OrderProduct
import com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.api.Order
import com.supplychainpoc.dropwizardapp.com.supplychainpoc.dropwizardapp.resources.OrderResource
import com.supplychainpoc.dropwizardapp.enums.OrderStatus
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport
import io.dropwizard.testing.junit5.ResourceExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID
import javax.ws.rs.client.Entity

@ExtendWith(DropwizardExtensionsSupport::class)
class OrderResourceTest {

    private val EXT = ResourceExtension.builder().addResource(OrderResource()).build()
    private val objectMapper = ObjectMapper()

    @Test
    fun create() {
        val resp = EXT.target("/orders").request().post(Entity.json(
            OrderModel(
                vendorId = UUID.randomUUID(),
                muid = UUID.randomUUID(),
                products = listOf(
                    OrderProduct(UUID.randomUUID(), 10),
                    OrderProduct(UUID.randomUUID(), 15),
                )
            )
        ))
        assertThat(resp.status).isEqualTo(201)
        val order = objectMapper.readValue(resp.readEntity(String::class.java), Order::class.java)
        assertThat(order.status).isEqualTo(OrderStatus.RECEIVED)
    }

    @Test
    fun list() {
        val resp = EXT.target("/orders").request().get()
        assertThat(resp.status).isEqualTo(200)
    }

    @Test
    fun get() {
        val createResp = EXT.target("/orders").request().post(Entity.json(
            OrderModel(
                vendorId = UUID.randomUUID(),
                muid = UUID.randomUUID(),
                products = listOf(
                    OrderProduct(UUID.randomUUID(), 10),
                    OrderProduct(UUID.randomUUID(), 15),
                )
            )
        ))
        val orderCreated = objectMapper.readValue(createResp.readEntity(String::class.java), Order::class.java)
        val resp = EXT.target("/orders/${orderCreated.id}").request().get()
        assertThat(resp.status).isEqualTo(200)
        val order =  objectMapper.readValue(resp.readEntity(String::class.java), Order::class.java)
        assertThat(order.status).isEqualTo(OrderStatus.RECEIVED)
    }

    @Test
    fun updateStatus() {
        val createResp = EXT.target("/orders").request().post(Entity.json(
            OrderModel(
                vendorId = UUID.randomUUID(),
                muid = UUID.randomUUID(),
                products = listOf(
                    OrderProduct(UUID.randomUUID(), 10),
                    OrderProduct(UUID.randomUUID(), 15),
                )
            )
        ))
        val orderCreated = objectMapper.readValue(createResp.readEntity(String::class.java), Order::class.java)
        val resp = EXT.target("/orders/${orderCreated.id}/${OrderStatus.READY_FOR_SHIPMENT}")
            .request()
            .method("PATCH", Entity.json("{}"))
        assertThat(resp.status).isEqualTo(204)
        val getResp = EXT.target("/orders/${orderCreated.id}").request().get()
        val order = objectMapper.readValue(getResp.readEntity(String::class.java), Order::class.java)
        assertThat(order.status).isEqualTo(OrderStatus.READY_FOR_SHIPMENT)
    }
}
