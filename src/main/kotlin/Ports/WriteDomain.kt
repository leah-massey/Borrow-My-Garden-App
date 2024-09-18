package com.example.Ports

import com.example.domain.models.Garden

interface WriteDomain {

    //should I have it return something??
    fun addGarden(garden: Garden)
}