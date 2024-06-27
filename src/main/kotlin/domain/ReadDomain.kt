package com.example.domain

import com.example.Ports.GardensRepo
import com.example.domain.models.Garden
import java.util.*

class ReadDomain(val gardensRepo: GardensRepo) {

    fun viewGardens(): List<Garden> {
        return gardensRepo.getGardens()
    }
}