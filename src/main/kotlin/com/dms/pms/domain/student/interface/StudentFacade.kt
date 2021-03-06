package com.dms.pms.domain.student.`interface`

import com.dms.pms.domain.student.domain.pms.Student

interface StudentFacade {
    fun findStudentIdByNumber(number: Long): String
    fun findAllStudentsByEmail(email: String): List<Student>
    fun findStudentByNumber(number: Long): Student
    fun checkIsUserHasStudentAndGetId(email: String, number: Long): String
}