package com.example.PostGresTests

import com.example.Adapters.all
import com.example.database.GardensTable
import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.postgresql.ds.PGSimpleDataSource
import java.util.UUID
import kotlin.test.assertEquals

class PostgresTestsGardens {

    val testDatasource = PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrow_my_garden_test_db"
    }

    val testDatabase = Database.connect(testDatasource)

    @BeforeEach fun resetDB() {
        transaction(testDatabase) {
            SchemaUtils.drop(GardensTable)
            SchemaUtils.createMissingTablesAndColumns(GardensTable)
        }
    }
    @Test
    fun `a garden profile can retrieved from the database`() {
        val garden = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "31081988",
            title = "Garden with good soil",
            description = "Everything grows fast in this garden",
            gardenOwnerFirstName = "John",
            gardenOwnerId = UUID.randomUUID(),
            gardenStatus = GardenStatus.AVAILABLE
        )
        transaction(testDatabase) {
            GardensTable.insert(garden)
            val readGardens: List<Garden> = GardensTable.all()
            assertEquals(readGardens, listOf(garden))
        }
    }

    @Test
    fun `a gardens table is initially empty`() {
        transaction(testDatabase) {
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




