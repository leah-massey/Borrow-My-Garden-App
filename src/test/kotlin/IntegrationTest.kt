import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import com.example.domain.models.MembershipStatus
import com.example.domain.models.User
import java.time.LocalDateTime
import java.util.*

open class IntegrationTest {

    fun randomActiveUser(): User = User(
        id = UUID.randomUUID(),
        firstName = "Ben",
        secondName = "Smith",
        membershipStatus = MembershipStatus.ACTIVE
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
        repeat(numberOfGardens) { scenario.appTestDatabase.add(randomGarden(user)) }

    private fun selectRandomStatus(): GardenStatus {
        return GardenStatus.values().toList().shuffled().first()
    }

    companion object {
        val scenario = TestScenario()
    }
}