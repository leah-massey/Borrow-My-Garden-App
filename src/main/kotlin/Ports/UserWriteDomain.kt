package Ports

import com.example.domain.models.User

interface UserWriteDomain {
    fun createUser(user: User)
}