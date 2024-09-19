package com.example.HttpApi

import IntegrationTest
import com.example.domain.models.Garden
import org.http4k.core.Method
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.http4k.core.*
import org.http4k.format.Jackson.mapper

class HttpApiTest : IntegrationTest() {
    @Test
    fun `GET internal_gardens_{gardenId} returns a single garden and 200 OK status`() {
        //given
        val user = randomActiveUser()

        val gardens: List<Garden> = multipleRandomAvailableGardens(user, 5)
        gardens.forEach{garden ->
            scenario.appTestDatabase.add(garden)
        }

        val garden1 = randomAvailableGarden(user)
        scenario.appTestDatabase.add(garden1)

        // when
        val request = Request(
            Method.GET,
            "internal/gardens/${garden1.id}"
        )
        val response = scenario.testApp.app(request)

        // then
        assertEquals(Status.OK, response.status)
        assertEquals(mapper.writeValueAsString(garden1), response.bodyString())
    }

    @Test
    fun `POST internal_gardens returns a 201 created response`() {

        // given
        val user = randomActiveUser()
        val garden = randomAvailableGarden(user)

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
        // is it enough to test only that this triggers deleteGarden to be called?
        // should I test that the db is not empty of garden with this id?

        // given
        val user = randomActiveUser()
        val garden = randomAvailableGarden(user)

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
}