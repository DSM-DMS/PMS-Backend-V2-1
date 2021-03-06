package com.dms.pms.domain.student.presentation

import com.dms.pms.domain.student.application.StudentService
import com.dms.pms.domain.student.presentation.dto.AddStudentDto
import com.dms.pms.domain.student.presentation.dto.DeleteStudentDto
import com.dms.pms.domain.student.presentation.dto.StudentInfoDto
import com.dms.pms.domain.user.domain.User
import com.dms.pms.global.security.UserInfo
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class StudentDelivery(
    private val studentService: StudentService
) {
    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    fun addStudent(@RequestBody @Valid request: AddStudentDto.Request, @UserInfo email: String): AddStudentDto.Response {
        return studentService.addStudent(request, email)
    }

    @DeleteMapping("/student")
    fun deleteStudent(@RequestBody @Valid request: DeleteStudentDto.Request, @UserInfo email: String): DeleteStudentDto.Response {
        return studentService.deleteStudent(request, email)
    }

    @GetMapping("/student/{number}")
    fun getStudentInfo(@PathVariable("number") number: Long, @UserInfo email: String): StudentInfoDto.Response {
        return studentService.getStudentInfo(number, email)
    }

}