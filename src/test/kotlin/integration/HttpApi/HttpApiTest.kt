package com.example.HttpApi

import IntegrationTest
import com.example.Adapters.HttpAPI
import com.example.Ports.ReadDomain
import com.example.Ports.WriteDomain
import com.example.domain.models.Garden
import org.http4k.core.Method
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.junit.jupiter.api.Assertions.*
import org.http4k.core.*
import org.http4k.format.Jackson.mapper


import java.util.*

class HttpApiTest : IntegrationTest() {
    @Test
    fun `GET internal_gardens_{gardenId} returns a single garden and 200 OK status`() {
        //given
        val user = randomActiveUser()
        val garden1 = randomAvailableGarden(user)
        val garden2 = randomAvailableGarden(user)
        val garden3 = randomAvailableGarden(user)
        val garden4 = randomAvailableGarden(user)
        val garden5 = randomAvailableGarden(user)

        scenario.appTestDatabase.add(garden1)
        scenario.appTestDatabase.add(garden2)
        scenario.appTestDatabase.add(garden3)
        scenario.appTestDatabase.add(garden4)
        scenario.appTestDatabase.add(garden5)

        // when
        val request = Request(
            Method.GET,
            "internal/gardens/${garden2.id}"
        )
        val response = scenario.testApp.app(request)

        // then
        assertEquals(Status.OK, response.status)
        assertEquals(mapper.writeValueAsString(garden2), response.bodyString())
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

        val response =

        val actualResponse = HttpAPI(mockReadDomain, mockWriteDomain).app(
            Request(Method.DELETE, "internal/gardens/de5ef0e7-0dbe-479c-a7c8-9f12db7ce225")
        )
        // then
        Mockito.verify(mockWriteDomain, Mockito.times(1)).deleteGarden(gardenId)
        assertEquals(Status.OK, actualResponse.status)
    }
}