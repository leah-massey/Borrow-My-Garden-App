package com.example.Ports

import com.example.domain.models.Garden
import java.util.*

interface ReadDomain {
    fun viewGardens(gardenId: UUID?): List<Garden>
}