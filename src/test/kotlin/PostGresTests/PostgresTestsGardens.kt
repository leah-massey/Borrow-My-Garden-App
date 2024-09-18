package com.example.PostGresTests


import com.example.database.*
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
    fun `garden profiles can retrieved from the database`() {
        val garden1 = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "31081988",
            title = "Garden with good soil",
            description = "Everything grows fast in this garden",
            gardenOwnerFirstName = "John",
            gardenOwnerId = UUID.randomUUID(),
            gardenStatus = GardenStatus.AVAILABLE
        )
        val garden2 = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "123",
            title = "Great Garden",
            description = "Some details",
            gardenOwnerFirstName = "Mary",
            gardenOwnerId = UUID.randomUUID(),
            gardenStatus = GardenStatus.AVAILABLE
        )

        transaction(testDatabase) {
            GardensTable.insert(garden1)
            GardensTable.insert(garden2)

            val readGardens: List<Garden> = GardensTable.all()
            assertEquals(readGardens, listOf(garden1, garden2))
        }
    }
    @Test
    fun `a single garden profile can retrieved from the database`() {
        val garden1 = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "31081988",
            title = "Garden with good soil",
            description = "Everything grows fast in this garden",
            gardenOwnerFirstName = "John",
            gardenOwnerId = UUID.randomUUID(),
            gardenStatus = GardenStatus.AVAILABLE
        )
        val garden2 = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "123",
            title = "Great Garden",
            description = "Some details",
            gardenOwnerFirstName = "Mary",
            gardenOwnerId = UUID.randomUUID(),
            gardenStatus = GardenStatus.AVAILABLE
        )

        transaction(testDatabase) {
            GardensTable.insert(garden1)
            GardensTable.insert(garden2)

            val singleGarden: Garden = GardensTable.findGardenById(garden2.id)
            assertEquals(singleGarden, garden2)
        }
    }

    @Test
    fun `a garden can be added`() {

        val newGarden = Garden(
            id = UUID.fromString("de5ef0e7-0dbe-479c-a7c8-9f12db7ce225"),
            createdTimestamp = "123",
            title = "Sunny Garden",
            description = "very sunny garden",
            gardenOwnerFirstName = "Bev",
            gardenOwnerId = UUID.fromString("73b0210b-3f30-4764-a31d-e25a83840eb7")
        )

        transaction(testDatabase) {
            GardensTable.addGardenToDB(newGarden)

            val readGardens: List<Garden> = GardensTable.all()
            assertEquals(listOf(newGarden), readGardens)
        }

    }

    @Test
    fun `an empty table returns an empty list`() {
        transaction(testDatabase) {
            assertEquals(GardensTable.all(), emptyList())
        }
    }
}






