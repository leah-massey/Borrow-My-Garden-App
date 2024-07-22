package com.example.Adapters

import com.example.domain.ReadDomain
import com.example.domain.models.Garden
import com.example.formats.JacksonMessage
import com.example.formats.jacksonMessageLens
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.http4k.core.*
import org.http4k.routing.bind
import org.http4k.routing.routes

class HttpAPI(readDomain: ReadDomain) {

    val app: HttpHandler = routes(

        "/api/gardens" bind Method.GET to { request: Request ->
            val gardens: List<Garden> = readDomain.viewGardens()
            val gardensAsJsonString: String = mapper.writeValueAsString(gardens)

            Response(Status.OK)
                .body(gardensAsJsonString)
                .header("content-type", "application/json")
        },


        "/ping" bind Method.GET to {
            Response(Status.OK).body("pong")
        }


    )
    private val mapper: ObjectMapper = jacksonObjectMapper()
}