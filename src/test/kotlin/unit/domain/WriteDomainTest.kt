package unit.domain

import com.example.Ports.GardensRepo
import com.example.domain.WriteDomain
import com.example.domain.models.Garden
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

class WriteDomainTest {
    @Test
    fun `the add garden method is triggered in the GardensRepo`() {
        //is there a better way of testing this?

        // given
        val newGarden = Garden(
            id = UUID.fromString("de5ef0e7-0dbe-479c-a7c8-9f12db7ce225"),
            createdTimestamp = "123",
            title = "Sunny Garden",
            description = "very sunny garden",
            gardenOwnerFirstName = "Bev",
            gardenOwnerId = UUID.fromString("73b0210b-3f30-4764-a31d-e25a83840eb7")
        )

        val mockGardenRepo: GardensRepo = Mockito.mock(GardensRepo::class.java)
        val writeDomain = WriteDomain(mockGardenRepo)
        // when
        writeDomain.addGarden(newGarden)
        //then
       Mockito.verify(mockGardenRepo, Mockito.times(1)).add(newGarden)
    }

    @Test
    fun `the delete method is triggered in the GardensRepo`() {
        // given
        val mockGardenRepo: GardensRepo = Mockito.mock(GardensRepo::class.java)
        val writeDomain = WriteDomain(mockGardenRepo)

        val gardenToBeDeleted = Garden(
            id = UUID.fromString("de5ef0e7-0dbe-479c-a7c8-9f12db7ce225"),
            createdTimestamp = "123",
            title = "Sunny Garden",
            description = "very sunny garden",
            gardenOwnerFirstName = "Bev",
            gardenOwnerId = UUID.fromString("73b0210b-3f30-4764-a31d-e25a83840eb7")
        )
        // when
        writeDomain.deleteGarden(gardenToBeDeleted.id)
        // then
        Mockito.verify(mockGardenRepo, Mockito.times(1)).delete(gardenToBeDeleted.id)
    }

    @Test
    fun `the update method is triggered for a specified garden`() {
        // given
        val mockGardenRepo: GardensRepo = Mockito.mock(GardensRepo::class.java)
        val writeDomain = WriteDomain(mockGardenRepo)

        val gardenToBeUpdated = Garden(
            id = UUID.fromString("de5ef0e7-0dbe-479c-a7c8-9f12db7ce225"),
            createdTimestamp = "123",
            title = "Sunny Garden",
            description = "it's nice",
            gardenOwnerFirstName = "Bev",
            gardenOwnerId = UUID.fromString("73b0210b-3f30-4764-a31d-e25a83840eb7")
        )

        // when
        writeDomain.updateGarden(gardenToBeUpdated.id, data = mapOf("title" to  "Very Sunny Garden"))

        // then
        Mockito.verify(mockGardenRepo, Mockito.times(1)).update(gardenToBeUpdated.id, mapOf("title" to  "Very Sunny Garden"))
    }
}