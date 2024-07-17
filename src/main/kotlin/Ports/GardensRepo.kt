package com.example.Ports

import com.example.domain.models.Garden

interface GardensRepo {
    fun getAllGardens(): List<Garden>

    fun add()
}