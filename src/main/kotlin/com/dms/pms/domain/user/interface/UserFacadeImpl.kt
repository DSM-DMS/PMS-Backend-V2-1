package com.dms.pms.domain.user.`interface`

import com.dms.pms.domain.user.domain.User
import com.dms.pms.domain.user.domain.repository.UserRepository
import com.dms.pms.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserFacadeImpl (
    private val userRepository: UserRepository
) : UserFacade {
    override fun getUserByEmail(email: String): User {
        return userRepository.findByIdOrNull(email) ?: throw UserNotFoundException.EXCEPTION
    }
}