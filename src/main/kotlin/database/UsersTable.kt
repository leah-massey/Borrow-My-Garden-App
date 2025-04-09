package database

import com.example.database.GardensTable
import com.example.database.toGarden
import com.example.domain.models.User
import org.jetbrains.exposed.sql.*
import java.util.*

object UsersTable: Table() {
    val id: Column<UUID> = uuid("id")
    val first_name: Column<String> = varchar("first_name", length = 20)
    val last_name: Column<String> = varchar("last_name", length = 20)
    val bio: Column<String?> = varchar("bio", length = 1000).nullable()
    val profile_pic: Column<String?> = varchar("profile_pic", length = 20).nullable() // this will change when I work out how to store my images - Amazon S3 would be good but costs
    val email: Column<String> = varchar("email", length = 40)
    val password: Column<String> = varchar("password", length = 40)
    override val primaryKey = PrimaryKey(id, name = "PK_User_Id")
}

fun UsersTable.all() = selectAll().map {
    it.toUser()
}

fun ResultRow.toUser(): User {
    val id = this[UsersTable.id]
    val firstName = this[UsersTable.first_name]
    val lastName = this[UsersTable.last_name]
    val bio = this[UsersTable.bio]
    val profilePic = this[UsersTable.profile_pic]
    val email = this[UsersTable.email]
    val password = this[UsersTable.password]
    return User(
        id,
        firstName,
        lastName,
        bio,
        profilePic,
        email,
        password
    )
}

fun UsersTable.insert(user: User) {
    insert {
        it[id] = user.id
        it[first_name] = user.firstName
        it[last_name] = user.lastName
        it[bio] = user.bio
        it[profile_pic] = user.profilePic
        it[email] = user.email
        it[password] = user.password
    }

}