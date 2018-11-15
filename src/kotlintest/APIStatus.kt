package kotlintest

enum class APIStatus(val code: Int) {
    OK(200),
    NOT_FOUND(404),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    UNKNOWN(0)
}