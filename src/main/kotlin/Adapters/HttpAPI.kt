package com.example.Adapters

import com.example.domain.ReadDomain
import com.example.domain.models.Garden
import org.http4k.core.*
import org.http4k.format.Jackson.mapper
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
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
        },

        "/ping" bind Method.GET to {
            Response(Status.OK).body("pong")
        }
    )
}