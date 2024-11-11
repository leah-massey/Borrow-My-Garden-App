package com.example.domain

import com.example.Adapters.SingleGardenRetrievalError
import com.example.Adapters.SingleGardenRetrievalError.GardenNotFound
import com.example.Ports.GardensRepo
import com.example.Ports.ReadDomain
import com.example.domain.models.Garden
import dev.forkhandles.result4k.Failure
import dev.forkhandles.result4k.Result4k
import dev.forkhandles.result4k.Success

import java.util.*

class ReadDomain(val gardensRepo: GardensRepo): ReadDomain {

    override fun viewGardens(): List<Garden> {
        return gardensRepo.getAll()
    }

    override fun viewSingleGarden(gardenId: UUID): Result4k<Garden, SingleGardenRetrievalError> {
        val garden: Result4k<Garden, SingleGardenRetrievalError> = gardensRepo.get(gardenId)
        return garden
    }
}