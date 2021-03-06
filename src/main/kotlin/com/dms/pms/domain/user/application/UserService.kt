package com.dms.pms.domain.user.application

import com.dms.pms.domain.student.`interface`.StudentFacade
import com.dms.pms.domain.user.domain.repository.UserRepository
import com.dms.pms.domain.user.exception.UserNotFoundException
import com.dms.pms.domain.user.presentation.dto.ChangeNameDto
import com.dms.pms.domain.user.presentation.dto.StudentListDto
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository,
    private val studentFacade: StudentFacade
) {
    fun getStudentList(email: String): StudentListDto.Response {
        val user = userRepository.findByIdOrNull(email)
            ?: throw UserNotFoundException.EXCEPTION

        val students = studentFacade.findAllStudentsByEmail(email)

        val studentList = students.map { student ->
            StudentListDto.Student(
                number = student.studentNumber,
                name = student.name
            )
        }

        return StudentListDto.Response(user.name, studentList)
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    fun changeName(request: ChangeNameDto.Request, email: String) {
        val user = userRepository.findByIdOrNull(email)
            ?: throw UserNotFoundException.EXCEPTION

        user.changeName(request.name)
    }
}