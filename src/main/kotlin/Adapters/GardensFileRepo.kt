package com.example.Adapters

import com.example.Ports.GardensRepo
import com.example.domain.models.Garden
import java.io.File

class GardensFileRepo(filePath: String): GardensRepo {

    val gardensFileRepo = File(filePath)

    override fun getAllGardens(): List<Garden> {

        TODO("Not yet implemented")
    }

    override fun add() {
        TODO("Not yet implemented")
    }
}