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

    fun randomAvailableGarden(user: User): Garden = Garden(
        id = UUID.randomUUID(),
        createdTimestamp = LocalDateTime.now().toString(),
        title = "Test Garden",
        description = "Test description",
        gardenOwnerFirstName = user.firstName,
        gardenOwnerId = user.id,
        gardenStatus = GardenStatus.AVAILABLE
    )

    fun multipleRandomAvailableGardens(user: User, numberOfGardens: Int): List<Garden> {
        return List(numberOfGardens) {
            randomAvailableGarden(user)
        }
    }

    companion object {
        val scenario = TestScenario()
    }
}