package com.example.Adapters

import com.example.Ports.GardensRepo
import com.example.database.*
import com.example.domain.models.Garden
import org.http4k.sse.SseMessage
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.postgresql.ds.PGSimpleDataSource
import java.util.UUID

class GardensPostgresRepo(datasource: PGSimpleDataSource): GardensRepo {
    val database = Database.connect(datasource)
    override fun getAll(): List<Garden> {
        return transaction(database) {
            GardensTable.all()
        }
    }
    override fun get(gardenId: UUID): Garden {
        return transaction(database) {
            GardensTable.findGardenById(gardenId)
        }
    }
    override fun add(garden: Garden) {
        return transaction(database) {
            GardensTable.addGardenToDB(garden)
        }
    }

    override fun delete(gardenId: UUID) {
        return transaction(database) {
            GardensTable.deleteGardenFromDB(gardenId)
        }
    }
}

