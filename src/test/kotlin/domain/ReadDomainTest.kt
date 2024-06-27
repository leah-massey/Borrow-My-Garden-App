package domain

import com.example.Adapters.GardensFileRepo
import com.example.Ports.GardensRepo
import com.example.domain.ReadDomain
import com.example.domain.models.Garden
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*


class ReadDomainTest {
    @Test
    fun `returns a list of gardens`() {
        // this is my test data - a list of gardens
        val testGarden = Garden(id = UUID.randomUUID(), createdTimestamp = "123", title = "Sunny Garden", description = "very sunny garden", gardenOwnerFirstName = "Bev", gardenOwnerId = UUID.randomUUID())
        val testGardens = listOf(testGarden)


        val mockGardenRepo: GardensRepo = mock(GardensRepo::class.java)
        `when` (mockGardenRepo.getGardens()).thenReturn(testGardens)

        val undertest = ReadDomain(mockGardenRepo)

        val expected = testGardens

        val actual = undertest.viewGardens()
        assertEquals(expected, actual)

    }
}