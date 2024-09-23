package com.example.Ports

import com.example.domain.models.Garden
import java.util.*

interface WriteDomain {

    //should I have it return something??
    fun addGarden(garden: Garden)
    fun deleteGarden(gardenId: UUID)
    fun updateGarden(gardenId: UUID, data: Map<String, Any>)
}