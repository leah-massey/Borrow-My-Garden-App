package com.example.PostGresTests


import com.example.Adapters.GardensPostgresRepo
import com.example.database.GardensTable
import com.example.database.all
import com.example.database.insert
import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
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

    val gardensPostgresTestRepo = GardensPostgresRepo(testDatasource)

    val garden1 = Garden(
        id = UUID.randomUUID(),
        createdTimestamp = "31081988",
        title = "Garden with good soil",
        description = "Everything grows fast in this garden",
        gardenOwnerFirstName = "John",
        gardenOwnerId = UUID.randomUUID(),
        gardenStatus = GardenStatus.AVAILABLE
    )
    val garden2 = Garden(id = UUID.randomUUID(), createdTimestamp = "20230723T083000Z", title = "Shady Retreat", description = "A peaceful garden with lots of shade", gardenStatus = GardenStatus.AVAILABLE, gardenOwnerFirstName = "Alice", gardenOwnerId = UUID.randomUUID())
    val garden3 = Garden(id = UUID.randomUUID(), createdTimestamp = "456", title = "Oasis in the city", description = "This is the place that you can come to to relax", gardenStatus = GardenStatus.NOT_AVAILABLE, gardenOwnerFirstName = "Jim", gardenOwnerId = UUID.randomUUID())
    val garden4 = Garden(id = UUID.randomUUID(), createdTimestamp = "147", title = "Blank Canvas", description = "You can do what you like with this garden - lots of nettles and rubble but could be great", gardenStatus = GardenStatus.NOT_AVAILABLE, gardenOwnerFirstName = "Buzz", gardenOwnerId = UUID.randomUUID())

    @BeforeEach fun resetDB() {
        transaction(gardensPostgresTestRepo.database) {
            SchemaUtils.drop(GardensTable)
            SchemaUtils.createMissingTablesAndColumns(GardensTable)
        }
    }

    @Test
    fun `a garden profile can retrieved from the database`() {

        transaction(gardensPostgresTestRepo.database) {
            GardensTable.insert(garden1)
            val readGardens: List<Garden> = GardensTable.all()
            assertEquals(readGardens, listOf(garden1))
        }
    }

    @Test
    fun `an empty table returns an empty list`() {
        transaction(gardensPostgresTestRepo.database) {
            assertEquals(GardensTable.all(), emptyList())
        }
    }

    @Test
    fun `a single garden can be retrieved from the database`() {

        transaction(gardensPostgresTestRepo.database) {
            GardensTable.insert(garden1)
            GardensTable.insert(garden2)
            GardensTable.insert(garden3)
            GardensTable.insert(garden4)

            assertEquals(gardensPostgresTestRepo.getGarden(garden1.id), garden1)
        }
    }
}






