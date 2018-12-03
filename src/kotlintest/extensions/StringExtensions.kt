package kotlintest.extensions

fun String.sayHello() = print("Hello $this");

fun String.toPlural(): String = this + "s";
var StringBuilder.firstLetter: Char
    get() = get(0)
    set(value) = this.setCharAt(0, value)