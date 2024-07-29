package domain

import com.example.Ports.GardensRepo
import com.example.domain.ReadDomain
import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*


class ReadDomainTest {
    @Test
    fun `returns a list of gardens`() {
        // this is my test data - a list of gardens
        val testGarden = Garden(id = UUID.randomUUID(), createdTimestamp = "123", title = "Sunny Garden", description = "very sunny garden", gardenStatus = GardenStatus.AVAILABLE, gardenOwnerFirstName = "Bev", gardenOwnerId = UUID.randomUUID())
        val testGardens = listOf(testGarden)


        val mockGardenRepo: GardensRepo = mock(GardensRepo::class.java)
        `when` (mockGardenRepo.getAllGardens()).thenReturn(testGardens)

        val undertest = ReadDomain(mockGardenRepo)

        val expected = testGardens

        val actual = undertest.viewGardens(null)
        assertEquals(expected, actual)
    }

    @Test
    fun `given a user wants to view the list of gardens available, when they request to view the gardens, only the available gardens are listed`() {
        //given
        val testGarden1 = Garden(id = UUID.randomUUID(), createdTimestamp = "123", title = "Sunny Garden", description = "very sunny garden", gardenStatus = GardenStatus.AVAILABLE, gardenOwnerFirstName = "Bev", gardenOwnerId = UUID.randomUUID())
        val testGarden2 = Garden(id = UUID.randomUUID(), createdTimestamp = "20230723T083000Z", title = "Shady Retreat", description = "A peaceful garden with lots of shade", gardenStatus = GardenStatus.AVAILABLE, gardenOwnerFirstName = "Alice", gardenOwnerId = UUID.randomUUID())
        val testGarden3 = Garden(id = UUID.randomUUID(), createdTimestamp = "456", title = "Oasis in the city", description = "This is the place that you can come to to relax", gardenStatus = GardenStatus.NOT_AVAILABLE, gardenOwnerFirstName = "Jim", gardenOwnerId = UUID.randomUUID())
        val testGarden4 = Garden(id = UUID.randomUUID(), createdTimestamp = "147", title = "Blank Canvas", description = "You can do what you like with this garden - lots of nettles and rubble but could be great", gardenStatus = GardenStatus.NOT_AVAILABLE, gardenOwnerFirstName = "Buzz", gardenOwnerId = UUID.randomUUID())

        val testGardens: List<Garden> = listOf(testGarden1, testGarden2, testGarden3, testGarden4)

        val mockGardenRepo: GardensRepo = mock(GardensRepo::class.java)
        `when` (mockGardenRepo.getAllGardens()).thenReturn(testGardens)

        val underTest = ReadDomain(mockGardenRepo)

        // when
        val actual = underTest.viewGardens(null)

        // then
        val expected = listOf(testGarden1, testGarden2)

        assertEquals(expected, actual)


    }
}