package com.dms.pms.domain.student.domain.pms.repository

import com.dms.pms.domain.student.domain.pms.QStudent.student
import com.dms.pms.domain.student.domain.pms.QStudentUser.studentUser
import com.dms.pms.domain.student.domain.pms.Student
import com.dms.pms.domain.student.domain.pms.StudentUser
import com.dms.pms.domain.student.domain.types.StudentUserKey
import com.dms.pms.domain.user.domain.QUser.user
import com.dms.pms.global.querydsl.PMSQueryDslRepositorySupport

class StudentUserRepositoryImpl : PMSQueryDslRepositorySupport(StudentUser::class.java), StudentUserRepositoryCustom {

    override fun isUserHasStudent(email: String, number: Long): Boolean {
        val studentUser = from(studentUser)
            .where(studentUser.studentUserKey.eq(StudentUserKey(email, number)))
            .fetchFirst()

        return studentUser != null
    }

    override fun deleteStudent(email: String, number: Long) {
        delete(studentUser)
            .where(studentUser.studentUserKey.eq(StudentUserKey(email, number)))
    }

    override fun findAllStudentsByEmail(email: String): List<Student> {
        return from(student)
            .innerJoin(studentUser).on(studentUser.studentUserKey.email.eq(user.email))
            .fetchJoin()
            .innerJoin(studentUser).on(studentUser.studentUserKey.studentCode.eq(student.studentCode))
            .where(studentUser.studentUserKey.email.eq(email))
            .orderBy(student.studentNumber.asc())
            .fetch()
    }
}