package com.example.Ports

import com.example.domain.models.Garden
import java.util.*

interface ReadDomain {
    fun viewGardens(): List<Garden>
    fun viewSingleGarden(gardenId: UUID): Garden?
}