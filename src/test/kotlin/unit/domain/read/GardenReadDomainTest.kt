package unit.domain.read

import com.example.Ports.GardensRepo
import com.example.domain.GardenReadDomain
import com.example.domain.models.Garden
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*


class GardenReadDomainTest {
    @Test
    fun `returns a list of gardens`() {
        // this is my test data - a list of gardens
        val testGarden1 = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "123",
            title = "Sunny Garden",
            description = "very sunny garden",
            gardenOwnerFirstName = "Bev",
            gardenOwnerId = UUID.randomUUID()
        )
        val testGarden2 = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "234",
            title = "Nice Garden",
            description = "really nice",
            gardenOwnerFirstName = "Stan",
            gardenOwnerId = UUID.randomUUID()
        )
        val testGardens = listOf(testGarden2)


        val mockGardenRepo: GardensRepo = mock(GardensRepo::class.java)
        `when` (mockGardenRepo.getAll()).thenReturn(testGardens)

        val undertest = GardenReadDomain(mockGardenRepo)

        val expected = testGardens

        val actual = undertest.viewGardens()
        assertEquals(expected, actual)

    }

    @Test
    fun `returns a single garden`() {
        val testGarden2 = Garden(
            id = UUID.randomUUID(),
            createdTimestamp = "234",
            title = "Nice Garden",
            description = "really nice",
            gardenOwnerFirstName = "Stan",
            gardenOwnerId = UUID.randomUUID()
        )

        val mockGardenRepo: GardensRepo = mock(GardensRepo::class.java)
        `when` (mockGardenRepo.get(testGarden2.id)).thenReturn(testGarden2)

        val underTest = GardenReadDomain(mockGardenRepo)

        val expected: Garden = testGarden2

        val actual = underTest.viewSingleGarden(testGarden2.id)
        assertEquals(expected, actual)

    }

//    @Test
//    fun `throws GardenNotFoundException when a garden does not exist`() {
//        // given
//        val mockGardenRepo: GardensRepo = mock(GardensRepo::class.java)
//        val gardenId = UUID.fromString("bc6629de-2399-4421-bbd3-46c4497924a3")
//
//        `when`(mockGardenRepo.get(gardenId)).thenThrow(
//            GardenNotFoundException(gardenId)
//        )
//
//        val underTest = ReadDomain(mockGardenRepo)
//
//        // when
//        val actual = underTest.viewSingleGarden(gardenId)
//
//        // then
//        assertEquals(GardenNotFoundException(gardenId), actual)
//    }
}