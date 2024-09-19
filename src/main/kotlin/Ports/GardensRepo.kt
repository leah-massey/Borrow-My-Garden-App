package com.example.Ports

import com.example.domain.models.Garden
import java.util.UUID

interface GardensRepo {
    fun getAll(): List<Garden>
    fun get(gardenId: UUID): Garden
    fun add(garden: Garden)
    fun delete(gardenId: UUID)
}