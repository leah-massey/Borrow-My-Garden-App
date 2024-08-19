package domain

import com.example.Ports.GardensRepo
import com.example.domain.ReadDomain
import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import io.mockk.every
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*
import io.mockk.mockk


class ReadDomainTest {

    val testGarden1 = Garden(id = UUID.randomUUID(), createdTimestamp = "123", title = "Sunny Garden", description = "very sunny garden", gardenStatus = GardenStatus.AVAILABLE, gardenOwnerFirstName = "Bev", gardenOwnerId = UUID.randomUUID())
    val testGarden2 = Garden(id = UUID.randomUUID(), createdTimestamp = "20230723T083000Z", title = "Shady Retreat", description = "A peaceful garden with lots of shade", gardenStatus = GardenStatus.AVAILABLE, gardenOwnerFirstName = "Alice", gardenOwnerId = UUID.randomUUID())
    val testGarden3 = Garden(id = UUID.randomUUID(), createdTimestamp = "456", title = "Oasis in the city", description = "This is the place that you can come to to relax", gardenStatus = GardenStatus.NOT_AVAILABLE, gardenOwnerFirstName = "Jim", gardenOwnerId = UUID.randomUUID())
    val testGarden4 = Garden(id = UUID.randomUUID(), createdTimestamp = "147", title = "Blank Canvas", description = "You can do what you like with this garden - lots of nettles and rubble but could be great", gardenStatus = GardenStatus.NOT_AVAILABLE, gardenOwnerFirstName = "Buzz", gardenOwnerId = UUID.randomUUID())
    val mockGardenRepo: GardensRepo = mockk<GardensRepo>()

    @Test
    fun `given a single available garden is in the repo, when the user requests to view the gardens, the garden is returned`() {
        //given
        val testGardens: List<Garden> = listOf(testGarden1)
        every { mockGardenRepo.getAllGardens() } returns testGardens
        val underTest = ReadDomain(mockGardenRepo)

        // when
        val actual = underTest.viewAllGardens(null)

        // then
        val expected = testGardens
        assertEquals(expected, actual)
    }

    @Test
    fun `given multiple gardens are in the repo, with varying availability, when the user requests to view the gardens, only the available gardens are returned`() {
        //given
        val testGardens: List<Garden> = listOf(testGarden1, testGarden2, testGarden3, testGarden4)
        every { mockGardenRepo.getAllGardens() } returns testGardens
        val underTest = ReadDomain(mockGardenRepo)

        // when
        val actual = underTest.viewAllGardens(null)

        // then
        val expected = listOf(testGarden1, testGarden2)

        assertEquals(expected, actual)
    }

    @Test
    fun `a single garden is returned`() {
        // given
        every {mockGardenRepo.getGarden(testGarden3.id)} returns testGarden3
        val underTest = ReadDomain(mockGardenRepo)

        // when
        val actual: Garden = underTest.viewGarden(testGarden3.id)

        // then
        val expected = testGarden3
        assertEquals(expected, actual)
    }
}