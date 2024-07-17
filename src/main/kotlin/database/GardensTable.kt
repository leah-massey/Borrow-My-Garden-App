package com.example.database

import com.example.domain.models.GardenStatus
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
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