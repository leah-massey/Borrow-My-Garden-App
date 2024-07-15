package com.example.domain.models

import java.util.UUID

data class Garden(
    val id: UUID,
    val createdTimestamp: String,
    val title: String,
    val description: String,
    val status: GardenStatus = GardenStatus.AVAILABLE,
    val gardenOwnerFirstName: String,
    val gardenOwnerId: UUID
)

enum class GardenStatus {
    AVAILABLE,
    NOT_AVAILABLE
}