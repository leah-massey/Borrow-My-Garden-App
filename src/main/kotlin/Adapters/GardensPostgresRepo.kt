package com.example.Adapters

import com.example.Ports.GardensRepo
import com.example.database.GardensTable
import com.example.database.all
import com.example.domain.models.Garden
import org.http4k.sse.SseMessage
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.postgresql.ds.PGSimpleDataSource
import java.util.*

class GardensPostgresRepo(datasource: PGSimpleDataSource): GardensRepo {
    val database = Database.connect(datasource)
    override fun getAllGardens(): List<Garden> {
        return transaction(database) {
            GardensTable.all()
        }
    }

    override fun getGarden(gardenId: UUID): Garden =
        transaction(database) {
            GardensTable.selectAll().where(GardensTable.id eq gardenId).limit(1).single().let { Garden fromRow it }
        }

    override fun add() {
        TODO("Not yet implemented")
    }
}

