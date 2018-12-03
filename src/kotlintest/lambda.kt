package kotlintest

val add = { a: Int, b: Int -> a + b }
val subtract = { a: Int, b: Int -> a - b }
var abs = { a: Int -> Math.abs(a) }


val users = listOf<User>(
        User("", "", 10),
        User("", "", 15),
        User("", "", 5),
        User("", "", 136)
)


fun users() {
    users.all { it.age > 10 }
    users.count { it.age > 20 }
    users.find { it.age > 20 }
    users.any { it.age > 20 }
}