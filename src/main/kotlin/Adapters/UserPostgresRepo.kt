package Adapters

import Ports.UserRepo
import com.example.domain.models.User
import database.UsersTable
import database.insert
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.postgresql.ds.PGSimpleDataSource

class UserPostgresRepo(datasource: PGSimpleDataSource): UserRepo {
    val database = Database.connect(datasource)
    override fun add(user: User) {
        return transaction(database) {
            UsersTable.insert(user)
        }
    }
}