package com.example.PostGresTests

import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.postgresql.ds.PGSimpleDataSource
import java.util.UUID
import kotlin.test.assertEquals

class PostGresTestsGardens {

    val datasource = PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrowmygarden"
    }

    val database = Database.connect(datasource)

    @BeforeEach fun resetDB() {
        transaction(database) {
            SchemaUtils.drop(Gardens)
            SchemaUtils.createMissingTablesAndColumns(Gardens)
        }
    }
    @Test
    fun `a garden profile can be added and retrieved from the database`() {
        val garden = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "31081988",
            title = "Garden with good soil",
            description = "Everything grows fast in this garden",
            gardenOwnerFirstName = "John",
            gardenOwnerId = UUID.randomUUID(),
            gardenStatus = GardenStatus.AVAILABLE
        )
        transaction(database) {
            Gardens.insert(garden)
            val readGardens: List<Garden> = Gardens.all()
            assertEquals(readGardens, listOf(garden))
        }
    }
}
private fun Gardens.insert(garden: Garden) {
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
private fun Gardens.all() = selectAll().map {
    val id = it[id]
    val createdTimestamp = it[created_timestamp]
    val title = it[title]
    val description = it[description]
    val gardenOwnerFirstName = it[garden_owner_first_name]
    val gardenOwnerId = it[garden_owner_id]
    val gardenStatus = it[garden_status]
    Garden(
        id,
        createdTimestamp = createdTimestamp,
        title,
        description,
        gardenOwnerFirstName = gardenOwnerFirstName,
        gardenOwnerId = gardenOwnerId,
        gardenStatus = gardenStatus
    )
}



object Gardens: Table() {
    val id: Column<UUID> = uuid("id")
    val created_timestamp: Column<String> = varchar("createdTimestamp", length = 100)
    val title: Column<String> = varchar("title", length = 100)
    val description: Column<String> = varchar("description", length = 1000)
    val garden_owner_first_name: Column<String> = varchar("gardenOwnerFirstName", length = 100)
    val garden_owner_id: Column<UUID> = uuid("gardenOwnerId")
    val garden_status: Column<GardenStatus> = enumerationByName("gardenStatus", length = 100)
    override val primaryKey = PrimaryKey(id, name = "PK_Gardens_Id")
}