package com.example.domain

import com.example.Ports.GardensRepo
import com.example.Ports.WriteDomain
import com.example.domain.models.Garden
import java.util.*

class WriteDomain(val gardensRepo: GardensRepo): WriteDomain {

    override fun addGarden(garden: Garden) = gardensRepo.add(garden)

    override fun deleteGarden(gardenId: UUID) = gardensRepo.delete(gardenId)

    override fun updateGardenTitle(gardenId: UUID, title: String) = gardensRepo.update(gardenId, title)
}