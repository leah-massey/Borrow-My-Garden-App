import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import com.example.domain.models.User
import java.time.LocalDateTime
import java.util.*

open class IntegrationTest {

    fun randomUser(): User = User(
        id = UUID.randomUUID(),
        firstName = "Ben",
        lastName = "Smith",
        email = "ben@ben.com",
        password = "test123"
    ) fun randomNewUser(firstName: String, secondName: String, email: String ): User = User(
        id = UUID.randomUUID(),
        firstName = firstName,
        lastName = secondName,
        email = email,
        password = "test123"
    )

    fun randomGarden(user: User): Garden = Garden(
        id = UUID.randomUUID(),
        createdTimestamp = LocalDateTime.now().toString(),
        title = "Test Garden",
        description = "Test Description",
        gardenOwnerFirstName = user.firstName,
        gardenOwnerId = user.id,
        gardenStatus = selectRandomStatus()
    )

    fun generateAndAddRandomGardensToDB(user: User, numberOfGardens: Int) =
        repeat(numberOfGardens) { scenario.appTestGardensDatabase.add(randomGarden(user)) }

    private fun selectRandomStatus(): GardenStatus {
        return GardenStatus.entries.shuffled().first()
    }

    companion object {
        val scenario = TestScenario()
    }
}