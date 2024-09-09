package com.example.Ports

import com.example.domain.models.Garden
import java.util.UUID

interface GardensRepo {
    fun getAllGardens(): List<Garden>
    fun getGarden(gardenId: UUID): Garden
    fun add()
}