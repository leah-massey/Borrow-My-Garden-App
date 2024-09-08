package com.example.domain

import com.example.Ports.GardensRepo
import com.example.domain.models.Garden
import java.util.*
import kotlin.test.todo

class ReadDomain(val gardensRepo: GardensRepo) {

    fun viewGardens(gardenId: UUID?): List<Garden> {
        if (gardenId == null) {
            return gardensRepo.getAllGardens()
        }
        else {
            return gardensRepo.getGarden(gardenId)
        }


    }
}