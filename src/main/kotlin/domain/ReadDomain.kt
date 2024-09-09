package com.example.domain

import com.example.Ports.GardensRepo
import com.example.Ports.ReadDomain
import com.example.domain.models.Garden
import java.util.*
import kotlin.test.todo

class ReadDomain(val gardensRepo: GardensRepo): ReadDomain {

    override fun viewGardens(): List<Garden> {
        return gardensRepo.getAllGardens()
    }
    override fun viewSingleGarden(gardenId: UUID): Garden {
        return gardensRepo.getGarden(gardenId)
    }
}