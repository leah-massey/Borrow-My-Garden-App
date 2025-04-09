package com.example.Adapters

import Ports.UserWriteDomain
import com.example.Ports.GardenWriteDomain
import com.example.domain.models.Garden
import com.example.domain.models.User
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.http4k.core.*
import org.http4k.filter.CorsPolicy
import org.http4k.filter.ServerFilters
import org.http4k.format.Jackson.auto
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import java.util.UUID

class HttpAPI(
    gardenReadDomain: com.example.Ports.GardenReadDomain,
    gardenWriteDomain: GardenWriteDomain,
    userWriteDomain: UserWriteDomain
) {
    val cors = ServerFilters.Cors(CorsPolicy.UnsafeGlobalPermissive)

    val app: HttpHandler = cors.then(routes(

        "internal/gardens" bind Method.GET to { request: Request ->
            // ask about testing the read domain and also the db
            val gardens: List<Garden> = gardenReadDomain.viewGardens()
            val gardensAsJsonString: String = mapper.writeValueAsString(gardens)

            Response(Status.OK)
                .body(gardensAsJsonString)
                .header("content-type", "application/json")
        },

        "internal/gardens" bind Method.POST to {request: Request ->
            request.header("content-type", "application/json")

            val gardenLens = Body.auto<Garden>().toLens()
            val newGarden: Garden = gardenLens(request)

            gardenWriteDomain.addGarden(newGarden)

            Response(Status.CREATED)
        },

        "internal/gardens" bind Method.OPTIONS to { request: Request ->
            // This is the preflight request, so we just return the allowed CORS headers
            Response(Status.OK)
        },

        "internal/gardens/{gardenId}" bind Method.GET to { request: Request ->
            val gardenId: UUID = UUID.fromString(request.path("gardenId"))
            val garden: Garden? = gardenReadDomain.viewSingleGarden(gardenId)
            val gardenAsJsonString: String = mapper.writeValueAsString(garden)


            Response(Status.OK)
                .body(gardenAsJsonString)
                .header("content-type", "application/json")
        },

        "internal/gardens/{gardenId}" bind Method.DELETE to {request: Request ->
            val gardenId: UUID = UUID.fromString(request.path("gardenId"))
            gardenWriteDomain.deleteGarden(gardenId)

            Response(Status.OK)
        },

        "internal/gardens/{gardenId}" bind Method.PATCH to { request: Request ->
            request.header("content-type", "application/json")
            val gardenId: UUID = UUID.fromString(request.path("gardenId"))

            val dataAsJson = request.bodyString()
            println("this is the data, ${dataAsJson}")

            val patchDataLens = Body.auto<Map<String, Any>>().toLens()
            val patchData  = patchDataLens(request)

            gardenWriteDomain.updateGarden(gardenId, patchData)

            Response(Status.OK)
        },

        "internal/create-user" bind Method.POST to { request: Request ->
            request.header("content-type", "application/json")

            val userLens = Body.auto<User>().toLens()
            val newUser = userLens(request)

            userWriteDomain.createUser(newUser)
            // TODO test if user email already registered

            Response(Status.CREATED)
        },

        "ping" bind Method.GET to { request: Request ->
            Response(Status.OK)
                .body("pong")
        }
    ))
    private val mapper: ObjectMapper = jacksonObjectMapper()
}