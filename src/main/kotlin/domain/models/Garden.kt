package com.example.domain.models

import com.example.database.GardensTable
import org.jetbrains.exposed.sql.ResultRow
import java.util.UUID

data class Garden(
    val id: UUID,
    val createdTimestamp: String,
    val title: String,
    val description: String,
    val gardenStatus: GardenStatus = GardenStatus.AVAILABLE,
    val gardenOwnerFirstName: String,
    val gardenOwnerId: UUID
){

companion object {
    infix fun fromRow(row: ResultRow): Garden {
        return Garden(
            id = row[GardensTable.id],
            createdTimestamp = row[GardensTable.created_timestamp],
            title = row[GardensTable.title],
            description = row[GardensTable.description],
            gardenStatus = row[GardensTable.garden_status],
            gardenOwnerFirstName = row[GardensTable.garden_owner_first_name],
            gardenOwnerId = row[GardensTable.garden_owner_id]
        )
    }
}
}

enum class GardenStatus {
    AVAILABLE,
    NOT_AVAILABLE
}