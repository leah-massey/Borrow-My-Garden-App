package com.example.Ports

import com.example.Adapters.SingleGardenRetrievalError
import com.example.domain.models.Garden
import dev.forkhandles.result4k.Result4k
import java.util.*

interface ReadDomain {
    fun viewGardens(): List<Garden>
    fun viewSingleGarden(gardenId: UUID): Result4k<Garden, SingleGardenRetrievalError>
}