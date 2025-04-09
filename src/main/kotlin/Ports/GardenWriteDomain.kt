package com.example.Ports

import com.example.domain.models.Garden
import com.example.domain.models.User
import java.util.*

interface GardenWriteDomain {
    fun addGarden(garden: Garden)
    fun deleteGarden(gardenId: UUID)
    fun updateGarden(gardenId: UUID, data: Map<String, Any>)
}