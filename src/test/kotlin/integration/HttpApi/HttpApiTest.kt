package com.example.HttpApi

import IntegrationTest
import org.http4k.core.Method
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.http4k.core.*
import org.http4k.format.Jackson.mapper
import java.util.*

class HttpApiTest : IntegrationTest() {
    @Test
    fun `GET internal_gardens_{gardenId} returns a single garden and 200 OK status`() {
        //given
        val user = randomActiveUser()
        generateAndAddRandomGardensToDB(user, 5)

        val garden = randomGarden(user)
        scenario.appTestDatabase.add(garden)

        // when
        val request = Request(
            Method.GET,
            "internal/gardens/${garden.id}"
        )
        val response = scenario.testApp.app(request)

        // then
        assertEquals(Status.OK, response.status)
        assertEquals(mapper.writeValueAsString(garden), response.bodyString())
    }

    @Test
    fun `GET internal_gardens_{gardenId} returns a 404 not found status when the garden is not present in the database`() {
        // given
        val user = randomActiveUser()
        val garden = randomGarden(user)

        scenario.appTestDatabase.add(garden)

        val gardenNotInDb = UUID.fromString("cefe78ea-a631-4631-9a47-a48d33415e9e")

        // when
        val request = Request(
            Method.GET,
            "internal/gardens/${gardenNotInDb}"
        )
        val response = scenario.testApp.app(request)

        // then
        assertEquals(response.status, Status.NOT_FOUND)

    }

    @Test
    fun `POST internal_gardens returns a 201 created response`() {

        // given
        val user = randomActiveUser()
        val garden = randomGarden(user)

        // when
        val request = Request(
            Method.POST,
            "internal/gardens"
        ).body(mapper.writeValueAsString(garden))

        val response = scenario.testApp.app(request)

        // then
        assertEquals(Status.CREATED, response.status)
    }

    @Test
    fun `DELETE internal_gardens_{gardenId} returns a 200 OK response`() {
        // should I test that the db is empty of garden with this id?

        // given
        val user = randomActiveUser()
        val garden = randomGarden(user)

        scenario.appTestDatabase.add(garden)

        // when
        val request = Request(
            Method.DELETE,
            "internal/gardens/${garden.id}"
        )

        val response = scenario.testApp.app(request)

        // then
        assertEquals(Status.OK, response.status)
    }

    @Test
    fun `PATCH internal_gardens_{gardenId} returns a garden with an updated title and a 200 status`() {
        // given
        val user = randomActiveUser()
        val garden = randomGarden(user)

        scenario.appTestDatabase.add(garden)

        // when
        val patchRequest = Request(
            Method.PATCH,
            "internal/gardens/${garden.id}"
        ).body("""{"title": "Test Garden Updated Title"}""")
            .header("content-type", "application/json")

        val patchResponse = scenario.testApp.app(patchRequest)

        val getResponse = scenario.testApp.app(
            Request(
                Method.GET,
                "internal/gardens/${garden.id}"
            )
        )

        val updatedGardenJSON = getResponse.bodyString()
        val updatedGarden = mapper.readTree(updatedGardenJSON)

        // then
        assertEquals(Status.OK, patchResponse.status)
        assertEquals("Test Garden Updated Title", updatedGarden["title"].asText())
    }

    @Test
    fun `Given a garden id that does not exist in the database, PATCH internal_gardens_{gardenId} returns a garden a 404 not found error`() {
        // when
        val patchRequest = Request(
            Method.PATCH,
            "internal/gardens/${UUID.randomUUID()}"
        ).body("""{"title": "Test Garden Updated Title"}""")
            .header("content-type", "application/json")

        val patchResponse = scenario.testApp.app(patchRequest)

        assertEquals(patchResponse.status, Status.NOT_FOUND)
    }
}