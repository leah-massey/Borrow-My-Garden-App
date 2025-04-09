package com.example.domain.models

import java.util.*

data class User (
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val bio: String? = null,
    val profilePic: String? = null,
    val email: String,
    val password: String
)

enum class MembershipStatus {
    ACTIVE,
    DEACTIVATED,
    PENDING
}