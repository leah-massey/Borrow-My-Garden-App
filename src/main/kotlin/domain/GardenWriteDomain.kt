package com.example.domain

import Ports.UserRepo
import com.example.Ports.GardensRepo
import com.example.Ports.GardenWriteDomain
import com.example.domain.models.Garden
import java.util.*

class GardenWriteDomain(val gardensRepo: GardensRepo):
    GardenWriteDomain {

    override fun addGarden(garden: Garden) = gardensRepo.add(garden)

    override fun deleteGarden(gardenId: UUID) = gardensRepo.delete(gardenId)

    override fun updateGarden(gardenId: UUID, data: Map<String, Any>) = gardensRepo.update(gardenId, data)
}