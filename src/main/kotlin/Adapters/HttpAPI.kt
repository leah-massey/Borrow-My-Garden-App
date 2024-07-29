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
            val gardenStatus: String? = request.query("gardenStatus")
//            val gardens: List<Garden> = readDomain.viewGardens()
            var gardensAsJsonString: String = ""

            if (gardenStatus == null) {
                val gardens: List<Garden> = readDomain.viewAllGardens(null)
                gardensAsJsonString = mapper.writeValueAsString(gardens)
                // default is to only return the available gardens
                //todo
            } else if (gardenStatus == "ALL") {
                //todo
            } else if (gardenStatus == "NOT_AVAILABLE") {
                //todo
            }

            Response(Status.OK)
                .body(gardensAsJsonString)
                .header("content-type", "application/json")
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
        },

        "/ping" bind Method.GET to {
            Response(Status.OK).body("pong")
        }
    )
}