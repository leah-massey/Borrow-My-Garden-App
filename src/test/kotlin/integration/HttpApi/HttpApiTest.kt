package com.example.HttpApi

import IntegrationTest
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
        generateAndAddRandomAvailableGardensToDB(user, 5)

        val garden = randomAvailableGarden(user)
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

//    @Test
//    fun `DELETE internal_gardens_{gardenId} returns a 200 OK response`() {
//        // is it enough to test only that this triggers deleteGarden to be called?
//        // should I test that the db is not empty of garden with this id?
//
//        // given
//        val user = randomActiveUser()
//        val garden = randomAvailableGarden(user)
//
//        scenario.appTestDatabase.add(garden)
//
//        // when
//        val request = Request(
//            Method.DELETE,
//            "internal/gardens/${garden.id}"
//        )
//
////        val response =
////
////        val actualResponse = HttpAPI(mockReadDomain, mockWriteDomain).app(
////            Request(Method.DELETE, "internal/gardens/de5ef0e7-0dbe-479c-a7c8-9f12db7ce225")
////        )
////        // then
////        Mockito.verify(mockWriteDomain, Mockito.times(1)).deleteGarden(gardenId)
////        assertEquals(Status.OK, actualResponse.status)
//    }
}