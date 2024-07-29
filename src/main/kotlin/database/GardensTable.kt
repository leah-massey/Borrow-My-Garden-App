package com.example.database

import com.example.database.insert
import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import org.jetbrains.exposed.sql.*
import java.util.*


    object GardensTable: Table() {
        val id: Column<UUID> = uuid("id")
        val created_timestamp: Column<String> = varchar("createdTimestamp", length = 100)
        val title: Column<String> = varchar("title", length = 100)
        val description: Column<String> = varchar("description", length = 1000)
        val garden_owner_first_name: Column<String> = varchar("gardenOwnerFirstName", length = 100)
        val garden_owner_id: Column<UUID> = uuid("gardenOwnerId")
        val garden_status: Column<GardenStatus> = enumerationByName("gardenStatus", length = 100)
        override val primaryKey = PrimaryKey(id, name = "PK_Gardens_Id")
    }

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

fun GardensTable.insert(gardens: List<Garden>) {
    gardens.map { garden ->
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
}