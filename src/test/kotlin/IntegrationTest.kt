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
        createdTimestamp = "24062022",
        title = LocalDateTime.now().toString(),
        description = "Test description",
        gardenOwnerFirstName = user.firstName,
        gardenOwnerId = user.id,
        gardenStatus = GardenStatus.AVAILABLE
    )

    companion object {
        val scenario = TestScenario()
    }
}