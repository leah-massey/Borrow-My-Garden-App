package com.example.Adapters

import com.example.Ports.GardensRepo
import com.example.database.GardensTable
import com.example.database.all
import com.example.domain.models.Garden
import org.http4k.sse.SseMessage
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.postgresql.ds.PGSimpleDataSource

class GardensPostgresRepo(datasource: PGSimpleDataSource): GardensRepo {
    val database = Database.connect(datasource)
    override fun getAllGardens(): List<Garden> {
        return transaction(database) {
            GardensTable.all()
        }
    }
    override fun add() {
        TODO("Not yet implemented")
    }
}

