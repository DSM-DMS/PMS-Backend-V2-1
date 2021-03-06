package com.dms.pms.global.error

enum class ErrorCode (
    val status: Int,
    val message: String
) {
    // Validation error codes
    MESSAGE_NOT_READABLE(400, "Message is not readable. check your json data"),
    INVALID_INPUT_VALUE(400, "Method argument is not valid"),
    INVALID_INPUT_TYPE(400, "Method argument type is not valid"),

    // User error codes
    USER_TOKEN_INVALID(401, "Invalid user token"),
    USER_HAS_NOT_STUDENT(403, "User has not student"),
    USER_NOT_FOUND(404, "User not found"),
    USER_ALREADY_EXIST(409, "User is already exist"),

    // Auth error codes
    AUTHENTICATION_NEED(401, "Authentication is required"),
    INSUFFICIENT_PERMISSION(403, "Insufficient permission"),
    EXPIRED_TOKEN(401, "Token is expired"),
    INVALID_TOKEN(401, "token is not valid"),
    PASSWORD_NOT_MATCHED(401, "Password is not matched"),
    TOKEN_NOT_FOUND(404, "Token is not found"),

    // Message error codes
    MESSAGE_SEND_FAILED(500, "Message send failed"),

    // Meal apply error codes
    MEAL_APPLY_NOT_FOUND(404, "Meal apply is not found"),

    // Student error codes
    STUDENT_NOT_FOUND(404, "Student is not found"),

    // Stay status not found
    STAY_STATUS_NOT_FOUND(404, "Stay status is not found"),

    // Point not found
    POINT_NOT_FOUND(404, "Point is not found"),

    // Point History not found
    POINT_HISTORY_NOT_FOUND(404, "Point history is not found"),

    // Path not found
    PATH_NOT_FOUND(404, "404: Not found"),

    // Server Error
    INTERNAL_SERVER_ERROR(500, "Something went wrong")
}