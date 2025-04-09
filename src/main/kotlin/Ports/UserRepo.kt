package Ports

import com.example.domain.models.User

interface UserRepo {
    fun add(user: User)
}