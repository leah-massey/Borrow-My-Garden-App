package com.example.HttpApi

import com.example.Adapters.HttpAPI
import com.example.Ports.GardensRepo
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
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes


import java.util.*

class HttpApiTest {
    @Test
    fun `a single garden is returned with a 200 OK status`() {

        val testGarden: Garden = (Garden
            (
            id = UUID.fromString("2df7f21c-eade-4ee0-ab0e-0b9cb5b5c053"),
            createdTimestamp = "24062022",
            title = "Nice garden",
            description = "South facing and sunny",
            gardenOwnerFirstName = "Marie",
            gardenOwnerId = UUID.fromString("41287d8b-4549-40e5-aec7-73ae4fd53ef5")
        )
                )

        val mockReadDomain: ReadDomain = Mockito.mock(ReadDomain::class.java)
        `when`(mockReadDomain.viewSingleGarden(UUID.fromString("2df7f21c-eade-4ee0-ab0e-0b9cb5b5c053"))).thenReturn(
            testGarden
        )
        val mockWriteDomain: WriteDomain = Mockito.mock(WriteDomain::class.java)

        val actualResponse = HttpAPI(mockReadDomain, mockWriteDomain).app(
            Request(
                Method.GET,
                "internal/gardens/2df7f21c-eade-4ee0-ab0e-0b9cb5b5c053"
            )
        )

        val testGardenAsString: String = mapper.writeValueAsString(testGarden)

        assertEquals(Status.OK, actualResponse.status)
        assertEquals(testGardenAsString, actualResponse.bodyString())
    }

    @Test
    fun `posting a garden returns a 201 created response`() {

        val mockReadDomain: ReadDomain = Mockito.mock(ReadDomain::class.java)
        val mockWriteDomain: WriteDomain = Mockito.mock(WriteDomain::class.java)

        val actualResponse = HttpAPI(mockReadDomain, mockWriteDomain).app(
            Request(Method.POST, "internal/gardens").body(
                """
            {
                "id": "de5ef0e7-0dbe-479c-a7c8-9f12db7ce225",
                "createdTimestamp": "234",
                "title": "Empty patch",
                "description": "I think this could be really nice for the right person ",
                "gardenOwnerFirstName": "Sonjay",
                "gardenOwnerId": "73b0210b-3f30-4764-a31d-e25a83840eb7"
            }
                """
            )
        )

        assertEquals(Status.CREATED, actualResponse.status)
    }

//    @Test
//    fun `a garden is deleted`() {
//        // given
//
//        // when
//
//        // then
//    }
}