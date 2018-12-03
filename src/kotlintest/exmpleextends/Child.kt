package kotlintest.exmpleextends

class Child(name: String) : Parent(name) {

    var index: Int = 0
        get() = field
        set(value) {
            field = value
        }

    constructor() : this("Greg")
    constructor(index: Int) : this("Test")

    override fun reload() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun load() {
        code = genarateCode()
        name = code
    }

    companion object {
        fun getClassName(): String = "Child"
    }
}

val childName = Child.getClassName()