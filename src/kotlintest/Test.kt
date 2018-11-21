package kotlintest

import kotlintest.utils.logMessage;


fun main(args: Array<String>) {
//    println("test")
////    newUser()
//    val res = sum(5, 5)
//    val result = sum(res, sum(15, 2))
//    println(result)
//    exempleFor()
//    exempleCast2("1212")
//    println(setOf(Color.RED, Color.BLUE) == setOf(Color.BLUE, Color.RED))
//    val color:String = mixColors(Color.RED, Color.BLUE)
//    println(color)
    checkNumber(8L)
}

fun test(): String {
    return "";
}

fun minOf(a: Int, b: Int): Int {
    return if (a < b) a else b
}

fun incrementLgt(i1: Int, i2: Int): Int {
    var a = i1
    var b = i2
    val res = if (a > b) {
        a++
        a
    } else {
        b++
        b
    }

    return res
}

fun statusAPI(status: APIStatus) {
    when (status) {
        APIStatus.OK -> print("OK")
        APIStatus.NOT_FOUND -> print("NOT FOUND")
        APIStatus.UNAUTHORIZED -> print("UNAUTHORIZED")
        APIStatus.FORBIDDEN -> print("FORBIDDEN")
        APIStatus.UNKNOWN -> print("UNKWOWN")
        else -> print("??????")
    }
}

fun statusAPICode(code: Int) {
    when (code) {
        APIStatus.OK.code, 201, 202 -> print("OK")
        APIStatus.NOT_FOUND.code -> print("NOT FOUND")
        APIStatus.UNAUTHORIZED.code -> print("UNAUTHORIZED")
        APIStatus.FORBIDDEN.code -> print("FORBIDDEN")
        APIStatus.UNKNOWN.code -> print("UNKWOWN")
        else -> print("??????")
    }

    when {
        isSucces(code) -> print("UNKWOWN")
        isError(code) -> print("ERROR")
    }
}

fun statusAPICode2(int: Int) {
    when (int) {
        in 1..33 -> print("Number is between 1 and 33")
        in 34..66 -> print("Number is between  34 and 66")
        in 67..100 -> print("Number is between 67 and 100")
        else -> print("Number upper at 100")
    }
}

fun isSucces(code: Int) = code == 200 || code == 201 || code == 202
fun isError(code: Int) = code == 400 || code == 404 || code == 403

class Test {
    var name: String? = "";

}


fun exempleFor() {
    val list1 = listOf("Greg", "Faris") // Permet de créer une liste d’éléments ordonnée et immuable.
    val list2 = mutableListOf("Greg", "Faris") // Permet de créer une liste d’éléments ordonnée et muable
    val list3 = setOf<String>("Greg", "Faris") // Permet de créer une liste d’éléments désordonnée et immuable.
    val list4 = mutableSetOf<String>("Greg", "Faris") // Permet de créer une liste d’éléments désordonnée et muable.


//    for (name in ar) {
    for ((index, name: String) in list1.withIndex()) {
        println(name + " " + index);
    }
    val len: Int = 5
    for (i: Int in 0..len) {
        println(i)
    }

    //for ()

    for (i: Int in list1.indices) {
        println("$i ${list1[i]}")
    }

    for (i in 10 downTo 0 step 4) {
        println("$i ======")
    }

    for (i in 1..10 step 2) {
        println("$i ======")
    }

}

fun exempleCast(obj: Any) {
    if (obj is String) {
        println(obj)
    } else if (obj is Int) {
        println(obj + 10)
    }
}

fun exempleCast2(obj: Any) {
    val message: String? = obj as? String
    println(message?.length)
}

fun subtractNumber(a: Int, b: Int) = if (a >= b) a - b else throw Exception("a is smaller than b")
fun fail(message: String): Nothing = throw IllegalStateException(message)


class User2(val email: String?, val password: String?)

fun user2() {
    val user = User2(email = "test", password = null)
    val password = user.password ?: fail("password null")
}

fun launchSubstract() {
    val a = 10
    val b = 5
    val res = try {
        subtractNumber(a, b)
    } catch (e: Exception) {
        0
    }
    print(res)
}

enum class Color { RED, GREEN, BLUE }

fun mixColors(color1: Color, color2: Color) = when (setOf(color1, color2)) {
    setOf(Color.RED, Color.GREEN) -> "Yellow"
    setOf(Color.BLUE, Color.RED) -> "Turquoise"
    else -> throw Exception("Too complex...")
}


fun checkNumber(number: Number) {
    when (number) {
        is Int -> print("It's an Integer")
        is Float -> print("It's a Float")
        is Double -> print("It's a Double")
        is Long -> print("It's a Long")
        else -> print("Error: Type not recognized...")
    }
}

fun test(a: Int = 0, b: String = "test"): String {
    return test(a, b, null)
}

fun test(a: Int = 0, b: String = "test", c: String?): String {
    logMessage("Test log message");
    return c ?: b;
}