package com.example.httpTests


import com.example.Adapters.HttpAPI
import com.example.domain.ReadDomain
import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import org.http4k.core.Method
import org.http4k.core.Request
import org.junit.jupiter.api.Test
import java.net.URI
import java.util.UUID
import org.http4k.core.*
import org.http4k.format.Jackson.auto
import kotlin.test.assertEquals
import io.mockk.mockk
import io.mockk.every

class httpHandlerTests {

    private val mockReadDomain: ReadDomain = mockk<ReadDomain>()
    private val api = HttpAPI(mockReadDomain)

    @Test fun`should return a single, specified garden`() {
        val gardenId = UUID.randomUUID()
        val expectedGarden = Garden(
            id = gardenId,
            createdTimestamp = "123",
            title = "Sunny Garden",
            description = "very sunny garden",
            gardenStatus = GardenStatus.AVAILABLE,
            gardenOwnerFirstName = "Bev",
            gardenOwnerId = UUID.randomUUID()
        )

         every {mockReadDomain.viewGarden(gardenId)} returns expectedGarden

        val request = Request(Method.GET, "api/garden")
        .query("gardenId", gardenId.toString())

        val response = api.app(request)

        val gardenLens = Body.auto<Garden>().toLens()

        val returnedGarden: Garden = gardenLens(response)

        assertEquals(Status.OK, response.status)
        assertEquals(expectedGarden, returnedGarden)
    }
}
