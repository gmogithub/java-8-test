package kotlintest

class User(email: String, password: String, var age: Int) {
    var email: String = email
        get() {
            println("get email => " + field)
            return field
        }
        set (value) {
            println("set email => " + value)
            field = value
        }

    var password: String = password
        get() {
            println("get password=> " + field)
            return field
        }
        set (value) {
            println("set password => " + value)
            field = value
        }


}


fun newUser() {
    val user: User = User("gm@viseo.com", "1515", 10)
    user.email
    user.password
}

fun toUppercase(str: String) = str.toUpperCase()

fun sum(a: Int, b: Int) = a + b