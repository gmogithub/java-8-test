package kotlintest.exmpleextends

import java.util.*

abstract open class Parent(var name: String) {
    var code: String = ""
        get () = field
        set(value) {
            field = value
        }

    fun genarateCode(): String {
        return UUID.randomUUID().toString()
    }

    open fun load() {
        code = genarateCode()
    }

    abstract fun reload();
}