package com.example.Ports

import com.example.Adapters.SingleGardenRetrievalError
import com.example.domain.models.Garden
import dev.forkhandles.result4k.Result4k
import java.util.UUID

interface GardensRepo {
    fun getAll(): List<Garden>
    fun get(gardenId: UUID): Result4k<Garden, SingleGardenRetrievalError>
    fun add(garden: Garden)
    fun delete(gardenId: UUID)
    fun update(gardenId: UUID, data: Map<String, Any>)
}