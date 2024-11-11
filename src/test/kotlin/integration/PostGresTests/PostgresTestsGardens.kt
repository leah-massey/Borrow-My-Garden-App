package com.example.PostGresTests


import com.example.Adapters.SingleGardenRetrievalError
import com.example.database.*
import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import com.natpryce.hamkrest.assertion.assertThat
import dev.forkhandles.result4k.Failure
import dev.forkhandles.result4k.Result4k
import dev.forkhandles.result4k.Success
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.postgresql.ds.PGSimpleDataSource
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.fail

class PostgresTestsGardens {
//
//    val testDatasource = PGSimpleDataSource().apply {
//        user = "postgres"
//        databaseName = "borrow_my_garden_test_db"
//    }
//
//    val testDatabase = Database.connect(testDatasource)
//
//
//    val garden1 = Garden(
//        id = UUID.randomUUID(),
//        createdTimestamp = "31081988",
//        title = "Garden with good soil",
//        description = "Everything grows fast in this garden",
//        gardenOwnerFirstName = "John",
//        gardenOwnerId = UUID.randomUUID(),
//        gardenStatus = GardenStatus.AVAILABLE
//    )
//    val garden2 = Garden(
//        id = UUID.randomUUID(),
//        createdTimestamp = "123",
//        title = "Great Garden",
//        description = "Some details",
//        gardenOwnerFirstName = "Mary",
//        gardenOwnerId = UUID.randomUUID(),
//        gardenStatus = GardenStatus.AVAILABLE
//    )
//
//    @BeforeEach
//    fun resetDB() {
//        transaction(testDatabase) {
//            SchemaUtils.drop(GardensTable)
//            SchemaUtils.createMissingTablesAndColumns(GardensTable)
//        }
//    }
//
//    @Test
//    fun `garden profiles can retrieved from the database`() {
//        // given
//        transaction(testDatabase) {
//            GardensTable.insert(garden1)
//            GardensTable.insert(garden2)
//            // when
//            val readGardens: List<Garden> = GardensTable.all()
//            // then
//            assertEquals(readGardens, listOf(garden1, garden2))
//        }
//    }
//
//    @Test
//    fun `a single garden profile can be retrieved from the database`() {
//        // given
//        transaction(testDatabase) {
//            GardensTable.insert(garden1)
//            GardensTable.insert(garden2)
//            // when
//            val singleGarden: Result4k<Garden, SingleGardenRetrievalError> = GardensTable.findGardenById(garden2.id)
//            // then
//
//            if (singleGarden is Success) {
//                assertEquals(garden2, singleGarden.value)
//            } else {
//                fail("Test failed - expected a Success but got a Failure.")
//            }
//        }
//    }
//
//    @Test
//    fun `a garden can be added`() {
//        // given
//        transaction(testDatabase) {
//            GardensTable.addGardenToDB(garden1)
//            // when
//            val readGardens: List<Garden> = GardensTable.all()
//            // then
//            assertEquals(listOf(garden1), readGardens)
//        }
//    }
//
//    @Test
//    fun `a garden can be deleted`() {
//        //given
//        transaction(testDatabase) {
//            GardensTable.insert(garden1)
//            GardensTable.insert(garden2)
//            //when
//            GardensTable.deleteGardenFromDB(garden1.id)
//            //then
//            assertEquals(listOf(garden2), GardensTable.all())
//        }
//    }
//
//    @Test
//    fun `an empty table returns an empty list`() {
//        transaction(testDatabase) {
//            assertEquals(GardensTable.all(), emptyList())
//        }
//    }
//
////    @Test
////    fun `a garden can have the title updated`() {
////        // given
////        transaction(testDatabase) {
////            GardensTable.insert(garden1)
////            GardensTable.insert(garden2)
////
////            // when
////            GardensTable.updateGardenInDB(garden1.id, mapOf("title" to "New Title"))
////
////            val updatedTitle: String = GardensTable.findGardenById(garden1.id).title
////
////            // then
////            assertEquals("New Title", updatedTitle )
////        }
////    }
//
//    @Test
//    fun `if a garden is not present in the DB, return GardenNotFoundException`() {
//
//        // given
//        val gardenId = UUID.fromString("5bd56dc9-4386-4eae-b333-f71b28a54432")
//
//        transaction(testDatabase) {
//            GardensTable.insert(garden1)
//            GardensTable.insert(garden2)
//
//            // then
//            assertThrows<GardenNotFoundException>{ GardensTable.findGardenById(gardenId) }
//        }
//    }
}






