package com.example.domain.models

import java.util.*

data class User (
    val id: UUID,
    val firstName: String,
    val secondName: String,
    val membershipStatus: MembershipStatus,
)

enum class MembershipStatus {
    ACTIVE,
    DEACTIVATED,
    PENDING
}