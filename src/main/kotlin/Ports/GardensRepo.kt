package com.example.Ports

import com.example.domain.models.Garden

interface GardensRepo {
    fun getGardens(): List<Garden>
}