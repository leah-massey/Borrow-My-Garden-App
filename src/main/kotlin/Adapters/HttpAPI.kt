package com.example.Adapters

import com.example.domain.ReadDomain
import com.example.domain.models.Garden
import com.example.formats.JacksonMessage
import com.example.formats.jacksonMessageLens
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.http4k.core.*
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import java.util.UUID

class HttpAPI(readDomain: com.example.Ports.ReadDomain) {

    val app: HttpHandler = routes(

        "internal/gardens" bind Method.GET to { request: Request ->
            // ask about testing the read domain and also the db
            val gardens: List<Garden> = readDomain.viewGardens(null)
            val gardensAsJsonString: String = mapper.writeValueAsString(gardens)

            Response(Status.OK)
                .body(gardensAsJsonString)
                .header("content-type", "application/json")
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
        },

        "internal/gardens/{gardenId}" bind Method.GET to { request: Request ->
            val gardenId: UUID = UUID.fromString(request.path("gardenId"))
            println("this is gardenId: ${gardenId}")
            val garden: List<Garden> = readDomain.viewGardens(gardenId)
            println("this is garden: ${garden}")
            val gardenAsJsonString: String = mapper.writeValueAsString(garden)

            Response(Status.OK)
                .body(gardenAsJsonString)
                .header("content-type", "application/json")
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
        }

    )
    private val mapper: ObjectMapper = jacksonObjectMapper()
}