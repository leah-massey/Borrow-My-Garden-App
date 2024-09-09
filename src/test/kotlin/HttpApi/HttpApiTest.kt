package com.example.HttpApi

import com.example.Adapters.HttpAPI
import com.example.Ports.GardensRepo
import com.example.Ports.ReadDomain
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
    fun `returns a garden`() {

        val testGarden: Garden = (Garden
            (
            id= UUID.fromString("2df7f21c-eade-4ee0-ab0e-0b9cb5b5c053"),
            createdTimestamp="24062022",
            title="Nice garden",
            description="South facing and sunny",
            gardenOwnerFirstName="Marie",
            gardenOwnerId=UUID.fromString("41287d8b-4549-40e5-aec7-73ae4fd53ef5")
            )
                )

        val mockReadDomain: ReadDomain = Mockito.mock(ReadDomain::class.java)
        `when` (mockReadDomain.viewGardens(UUID.fromString("2df7f21c-eade-4ee0-ab0e-0b9cb5b5c053"))).thenReturn(listOf(testGarden))

        val expectedResponse = Response(Status.OK)
            .header("content-type", "application/json")
            .header("Access-Control-Allow-Origin", "*")
            .body(mapper.writeValueAsString(listOf(testGarden)))

        val actualResponse = HttpAPI(mockReadDomain).app(Request(Method.GET, "internal/gardens/2df7f21c-eade-4ee0-ab0e-0b9cb5b5c053"))

        assertEquals(expectedResponse, actualResponse)
    }
}