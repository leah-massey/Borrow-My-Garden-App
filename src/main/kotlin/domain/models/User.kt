package com.example.domain.models

import java.util.*

data class User (
    val id: UUID,
    val firstName: String,
    val secondName: String,
    val email: String,
    val bio: String? = null,
    val profilePic: String? = null,
)

enum class MembershipStatus {
    ACTIVE,
    DEACTIVATED,
    PENDING
}