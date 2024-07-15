package com.example.PGTests

import com.example.domain.models.MembershipStatus
import com.example.domain.models.User
import org.jetbrains.exposed.sql.*


import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
//import kotlin.test.expectThat

import org.postgresql.ds.PGSimpleDataSource
import java.util.*
import kotlin.test.assertEquals


class PGTests {

    val dataSource = PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrowmygarden"
    }

    val database = Database.connect(dataSource)

    @BeforeEach fun resetDB() {
        transaction(database) {
            SchemaUtils.drop(Users)
            SchemaUtils.createMissingTablesAndColumns(Users) // you can add multiple tables here within the brackets
        }
    }
    @Test
    fun `a user can be added to and retrieved from the database`() {
        val user = User(UUID.randomUUID(), "Jenny", "Long", MembershipStatus.ACTIVE )
        transaction(database) {
            Users.insert(user)
            val readUsers: List<User> = Users.all()
            assertEquals(readUsers, listOf(user))
        }
    }
}
private fun Users.insert(user: User) {
    insert {
        it[id] = user.id
        it[firstName] = user.firstName
        it[secondName] = user.secondName
        it[membershipStatus] = user.membershipStatus
    }
}
private fun Users.all(): List<User> {
    val readUsers: List<User> = selectAll().map {
        val id = it[id]
        val firstName = it[firstName]
        val secondName = it[secondName]
        val membershipStatus = it[membershipStatus]
        User(id, firstName, secondName, membershipStatus)
    }
    return readUsers
}


object Users: Table() {
    val id: Column<UUID> = uuid("id")
    val firstName: Column<String> = varchar("firstName", 100)
    val secondName: Column<String> = varchar("secondName", 100)
    val membershipStatus: Column<MembershipStatus> = enumerationByName("membershipStatus", 20, MembershipStatus::class)
    override val primaryKey = PrimaryKey(id, name = "PK_Users_Id")
}