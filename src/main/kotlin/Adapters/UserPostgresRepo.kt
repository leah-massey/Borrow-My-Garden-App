package Adapters

import Ports.UserRepo
import com.example.domain.models.User
import org.jetbrains.exposed.sql.Database
import org.postgresql.ds.PGSimpleDataSource

class UserPostgresRepo(datasource: PGSimpleDataSource): UserRepo {
    val database = Database.connect(datasource)

    override fun add(user: User) {
        TODO("Not yet implemented")
    }
}