package com.example

import com.example.Adapters.GardensPostgresRepo
import com.example.Ports.GardensRepo
import com.example.formats.JacksonMessage
import com.example.formats.jacksonMessageLens
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.core.with
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer
import org.postgresql.ds.PGSimpleDataSource

val app: HttpHandler = routes(
    "/ping" bind GET to {
        Response(OK).body("pong")
    },

    "/formats/json/jackson" bind GET to {
        Response(OK).with(jacksonMessageLens of JacksonMessage("Barry", "Hello there!"))
    }
)

fun main() {
    val gardensRepo: GardensRepo = GardensPostgresRepo(PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrowmygarden"
    })
    val printingApp: HttpHandler = PrintRequest().then(app)

    val server = printingApp.asServer(SunHttp(9000)).start()

    println("Server started on " + server.port())
}
