package com.example.database

import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.util.*

object GardensTable : Table() {
    val id: Column<UUID> = uuid("id")
    val created_timestamp: Column<String> = varchar("created_timestamp", length = 100)
    val title: Column<String> = varchar("title", length = 100)
    val description: Column<String> = varchar("description", length = 1000)
    val garden_owner_first_name: Column<String> = varchar("garden_owner_first_name", length = 100)
    val garden_owner_id: Column<UUID> = uuid("garden_owner_id")
    val garden_status: Column<GardenStatus> = enumerationByName("garden_status", length = 100)
    override val primaryKey = PrimaryKey(id, name = "PK_Gardens_Id")
}

class GardenNotFoundException(gardenId: UUID) : RuntimeException("Garden with ID $gardenId not found")


fun GardensTable.all() = selectAll().map {
    it.toGarden()
}

fun GardensTable.findGardenById(gardenId: UUID): Garden {
    return GardensTable.selectAll()
        .filter { it[GardensTable.id] == gardenId }
        .map { it.toGarden() }
        .firstOrNull() ?: throw GardenNotFoundException(gardenId)
}

fun GardensTable.addGardenToDB(garden: Garden) = GardensTable.insert(garden)

fun GardensTable.deleteGardenFromDB(gardenId: UUID) = GardensTable.deleteWhere { GardensTable.id eq gardenId }
// TODO handle case where garden does not exist

fun GardensTable.updateGardenInDB(gardenId: UUID, data: Map<String, Any>) {

    // check that garden exists
    GardensTable.selectAll()
        .filter { it[GardensTable.id] == gardenId }
        .firstOrNull() ?: throw GardenNotFoundException(gardenId)

    // update garden
    GardensTable.update({ GardensTable.id eq gardenId }) {
        data.forEach { (key, value) ->
            when (key) {
                "title" -> it[GardensTable.title] = value as String
                "description" -> it[GardensTable.description] = value as String
                "garden_status" -> it[GardensTable.garden_status] = value as GardenStatus
            }
        }
    }
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

fun GardensTable.insert(garden: Garden) {
    insert {
        it[id] = garden.id
        it[created_timestamp] = garden.createdTimestamp
        it[title] = garden.title
        it[description] = garden.description
        it[garden_owner_first_name] = garden.gardenOwnerFirstName
        it[garden_owner_id] = garden.gardenOwnerId
        it[garden_status] = garden.gardenStatus
    }
}