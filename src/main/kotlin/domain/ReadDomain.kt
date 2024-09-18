package com.example.domain

import com.example.Ports.GardensRepo
import com.example.Ports.ReadDomain
import com.example.domain.models.Garden
import java.util.*

class ReadDomain(val gardensRepo: GardensRepo): ReadDomain {

    override fun viewGardens(): List<Garden> {
        return gardensRepo.getAll()
    }
    override fun viewSingleGarden(gardenId: UUID): Garden {
        return gardensRepo.get(gardenId)
    }
}