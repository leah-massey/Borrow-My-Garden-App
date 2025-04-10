package com.example.HttpApi

import IntegrationTest
import org.http4k.core.Method
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.http4k.core.*
import org.http4k.format.Jackson.mapper
import org.junit.jupiter.api.Disabled

class EndpointTests : IntegrationTest() {
    @Test
    fun `GET internal_gardens_{gardenId} returns a single garden and 200 OK status`() {
        //given
        val user = randomUser()
        generateAndAddRandomGardensToDB(user, 5)

        val garden = randomGarden(user)
        scenario.appTestGardensDatabase.add(garden)

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
    fun `POST internal_gardens returns a 201 created response`() {

        // given
        val user = randomUser()
        val gardenInJsonStringFormat = mapper.writeValueAsString(randomGarden(user))

        // when
        val request = Request(
            Method.POST,
            "internal/gardens"
        ).body(gardenInJsonStringFormat)

        val response = scenario.testApp.app(request)

        // then
        assertEquals(Status.CREATED, response.status)
    }

    @Test
    fun `DELETE internal_gardens_{gardenId} returns a 200 OK response`() {
        // should I test that the db is empty of garden with this id?

        // given
        val user = randomUser()
        val garden = randomGarden(user)

        scenario.appTestGardensDatabase.add(garden)

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
        val user = randomUser()
        val garden = randomGarden(user)

        scenario.appTestGardensDatabase.add(garden)

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
    fun `POST internal_create-user returns a 201 created status`() {
        //given
        val userInJsonStringFormat = mapper.writeValueAsString(randomNewUser("John", "Brown", "john@john.com"))

        //when
        val request = Request(
            Method.POST,
            "internal/create-user"
        ).body(userInJsonStringFormat)

        val response = scenario.testApp.app(request)

        //then
        assertEquals(Status.CREATED, response.status)
    }
}