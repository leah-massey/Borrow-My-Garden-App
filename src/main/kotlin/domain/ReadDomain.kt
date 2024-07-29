package com.example.domain

import com.example.Ports.GardensRepo
import com.example.domain.models.Garden
import com.example.domain.models.GardenStatus
import java.util.UUID
import kotlin.test.todo

class ReadDomain(val gardensRepo: GardensRepo) {

    fun viewAllGardens(gardenStatus: String?): List<Garden> {
        if (gardenStatus == null) {
            return gardensRepo.getAllGardens().filter { garden ->
                garden.gardenStatus == GardenStatus.AVAILABLE
            }
        }
        return gardensRepo.getAllGardens()
    }

    fun viewGarden(id: UUID): Garden {
        return gardensRepo.getGarden(id)
    }
}