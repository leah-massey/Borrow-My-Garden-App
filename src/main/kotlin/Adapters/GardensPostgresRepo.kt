package com.example.Adapters

import com.example.Ports.GardensRepo
import com.example.database.GardensTable
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
        return GardensTable.all()
    }
    override fun add() {
        TODO("Not yet implemented")
    }


}

// not sure where I should keep these?? 👇🏻
fun GardensTable.all() = selectAll().map {
    it.toGarden()
}

fun ResultRow.toGarden(): Garden {
    val id = this[GardensTable.id]
    val createdTimestamp = this[GardensTable.created_timestamp]
    val title = this[GardensTable.title]
    val description = this[GardensTable.description]
    val gardenOwnerFirstName = this[GardensTable.garden_owner_first_name]
    val gardenOwnerId = this[GardensTable.garden_owner_id]
    val gardenStatus = this[GardensTable.garden_status]
    return Garden(
        id,
        createdTimestamp = createdTimestamp,
        title,
        description,
        gardenOwnerFirstName = gardenOwnerFirstName,
        gardenOwnerId = gardenOwnerId,
        gardenStatus = gardenStatus
    )
}
