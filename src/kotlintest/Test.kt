package kotlintest


fun main(args: Array<String>) {
    println("test")
//    newUser()
    val res = sum(5, 5)
    val result = sum(res, sum(15, 2))
    println(result)
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

fun statusAPI (status: APIStatus) {
    when (status) {
        APIStatus.OK -> print("OK")
        APIStatus.NOT_FOUND -> print("NOT FOUND")
        APIStatus.UNAUTHORIZED -> print("UNAUTHORIZED")
        APIStatus.FORBIDDEN -> print("FORBIDDEN")
        APIStatus.UNKNOWN -> print("UNKWOWN")
        else -> print("??????")
    }
}

fun statusAPICode (code: Int) {
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

fun statusAPICode2 (int: Int) {
    when (int) {
        in 1..33 -> print("Number is between 1 and 33")
        in 34..66 -> print("Number is between  34 and 66")
        in 67..100 -> print("Number is between 67 and 100")
        else -> print("Number upper at 100")
    }
}

fun isSucces (code: Int) = code == 200 || code == 201 || code == 202
fun isError (code: Int) = code == 400 || code == 404 || code == 403

class Test {
    var name: String? = "";

}


