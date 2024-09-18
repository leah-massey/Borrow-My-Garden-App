package com.example

import com.example.Adapters.GardensPostgresRepo
import com.example.Adapters.HttpAPI
import com.example.Ports.GardensRepo
import com.example.domain.ReadDomain
import com.example.domain.WriteDomain
import org.http4k.core.HttpHandler
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.server.SunHttp
import org.http4k.server.asServer
import org.postgresql.ds.PGSimpleDataSource



fun main() {
    val gardensRepoDatasource: GardensRepo = GardensPostgresRepo(PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrowmygarden"
    })
    val readDomain = ReadDomain(gardensRepoDatasource)
    val writeDomain = WriteDomain(gardensRepoDatasource)
    val httpAPI = HttpAPI(readDomain, writeDomain)

    val printingApp: HttpHandler = PrintRequest().then(httpAPI.app)

    val server = printingApp.asServer(SunHttp(9000)).start()

    println("Server started on " + server.port())
}
