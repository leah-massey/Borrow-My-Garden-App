package domain

import Ports.UserRepo
import Ports.UserWriteDomain
import com.example.domain.models.User

class UserWriteDomain(val userRepo: UserRepo): UserWriteDomain {

    override fun createUser(user: User) = userRepo.add(user)

}