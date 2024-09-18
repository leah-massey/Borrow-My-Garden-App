package com.example.domain

import com.example.Ports.GardensRepo
import com.example.Ports.WriteDomain
import com.example.domain.models.Garden

class WriteDomain(val gardensRepo: GardensRepo): WriteDomain {

    override fun addGarden(garden: Garden) = gardensRepo.add(garden)
}