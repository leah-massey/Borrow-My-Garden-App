package unit.domain.write

import Ports.UserRepo
import com.example.domain.models.User
import domain.UserWriteDomain
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

class UserWriteDomainTest {
    @Test
    fun `createUser triggers the add user method in the User Repo`() {
        //given
        val newUser = User(
            id = UUID.randomUUID(),
            firstName = "Elviz",
            lastName = "Hemming",
            email = "elviz@elviz.com",
            password = "test123"
        )

        val mockUserRepo: UserRepo = Mockito.mock(UserRepo::class.java)
        val writeDomain = UserWriteDomain(mockUserRepo)

        //when
        writeDomain.createUser(newUser)

        //then
        Mockito.verify(mockUserRepo, Mockito.times(1)).add(newUser)

    }
}