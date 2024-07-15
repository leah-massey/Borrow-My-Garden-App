package com.example.PostGresTests

import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import com.natpryce.hamkrest.assertion.assertThat
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.postgresql.ds.PGSimpleDataSource
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.expect

class PostgresTestsGardens {

    val datasource = PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrowmygarden"
    }

    val database = Database.connect(datasource)

    @BeforeEach fun resetDB() {
        transaction(database) {
            SchemaUtils.drop(GardensTable)
            SchemaUtils.createMissingTablesAndColumns(GardensTable)
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
            GardensTable.insert(garden)
            val readGardens: List<Garden> = GardensTable.all()
            assertEquals(readGardens, listOf(garden))
        }
    }

    @Test
    fun `a gardens table is initially empty`() {
        transaction(database) {
            assertEquals(GardensTable.all(), emptyList())
        }
    }
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