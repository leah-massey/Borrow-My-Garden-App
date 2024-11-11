//package com.example.HttpApi
//
//import IntegrationTest
//import com.example.Adapters.SingleGardenRetrievalError
//import com.example.domain.models.Garden
//import dev.forkhandles.result4k.Failure
//import dev.forkhandles.result4k.Result4k
//import dev.forkhandles.result4k.valueOrNull
//import org.http4k.core.Method
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.Assertions.*
//import org.http4k.core.*
//import org.http4k.format.Jackson.mapper
//import java.util.*
//
//class HttpApiTest : IntegrationTest() {
////    @Test
////    fun `GET internal_gardens_{gardenId} returns a single garden and 200 OK status`() {
////        //given
////        val user = randomActiveUser()
////        generateAndAddRandomGardensToDB(user, 5)
////
////        val garden = randomGarden(user)
////        scenario.appTestDatabase.add(garden)
////
////        // when
////        val request = Request(
////            Method.GET,
////            "internal/gardens/${garden.id}"
////        )
////        val response = scenario.testApp.app(request)
////
////        val responseAsResult4k = mapper.readValue(response.bodyString(), Result4k::class.java)
////
////        println(responseAsResult4k)
////        println("OOOOOOOOO")
////        val actualGarden = responseAsResult4k.valueOrNull() as Garden
////        // then
////        assertEquals(Status.OK, response.status)
////        assertEquals(garden, actualGarden)
////    }
//
//    @Test
//    fun `given an invalid garden ID, GET internal_gardens_{gardenId} returns and error message`() {
//
//        // when
//        val request = Request(
//            Method.GET,
//            "internal/gardens/9d66ca14-8889-40ff-bb68-75de273d8fa5"
//        )
//        val response = scenario.testApp.app(request)
//
//        // then
//    val expectedError = Failure(SingleGardenRetrievalError.GardenNotFound(UUID.fromString("9d66ca14-8889-40ff-bb68-75de273d8fa5")))
//
//        assertEquals(expectedError, response.body)
//    }
//
//    @Test
//    fun `POST internal_gardens returns a 201 created response`() {
//
//        // given
//        val user = randomActiveUser()
//        val garden = randomGarden(user)
//
//        // when
//        val request = Request(
//            Method.POST,
//            "internal/gardens"
//        ).body(mapper.writeValueAsString(garden))
//
//        val response = scenario.testApp.app(request)
//
//        // then
//        assertEquals(Status.CREATED, response.status)
//    }
//
//    @Test
//    fun `DELETE internal_gardens_{gardenId} returns a 200 OK response`() {
//        // should I test that the db is empty of garden with this id?
//
//        // given
//        val user = randomActiveUser()
//        val garden = randomGarden(user)
//
//        scenario.appTestDatabase.add(garden)
//
//        // when
//        val request = Request(
//            Method.DELETE,
//            "internal/gardens/${garden.id}"
//        )
//
//        val response = scenario.testApp.app(request)
//
//        // then
//        assertEquals(Status.OK, response.status)
//    }
//
//    @Test
//    fun `PATCH internal_gardens_{gardenId} returns a garden with an updated title and a 200 status`() {
//        // given
//        val user = randomActiveUser()
//        val garden = randomGarden(user)
//
//        scenario.appTestDatabase.add(garden)
//
//        // when
//        val patchRequest = Request(
//            Method.PATCH,
//            "internal/gardens/${garden.id}"
//        ).body("""{"title": "Test Garden Updated Title"}""")
//            .header("content-type", "application/json")
//
//        val patchResponse = scenario.testApp.app(patchRequest)
//
//        val getResponse = scenario.testApp.app(
//            Request(
//                Method.GET,
//                "internal/gardens/${garden.id}"
//            )
//        )
//
//        val updatedGardenJSON = getResponse.bodyString()
//        val updatedGarden = mapper.readTree(updatedGardenJSON)
//
//        // then
//        assertEquals(Status.OK, patchResponse.status)
//        assertEquals("Test Garden Updated Title", updatedGarden["title"].asText())
//    }
//}