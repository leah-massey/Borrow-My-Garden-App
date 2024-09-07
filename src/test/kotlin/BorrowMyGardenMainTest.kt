package com.example

import com.example.Adapters.GardensPostgresRepo
import com.example.Adapters.HttpAPI
import com.example.Ports.GardensRepo
import com.example.domain.ReadDomain
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.postgresql.ds.PGSimpleDataSource

class BorrowMyGardenMainTest {
//    @Test
//    fun `Ping test`() {
//        val gardensRepoDatasource: GardensRepo = GardensPostgresRepo(PGSimpleDataSource().apply {
//            user = "postgres"
//            databaseName = "borrowmygarden"
//        })
//        val readDomain = ReadDomain(gardensRepoDatasource)
//        val httpAPI = HttpAPI(readDomain)
//
//        assertEquals(Response(OK).body("pong"), httpAPI.app(Request(GET, "/ping")))
//    }
}
