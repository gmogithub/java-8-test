package kotlintest

interface ModelFactory<T> {
    fun newInstanceFromJson(json: String): T
}

data class DataTest(var code: String, var name: String) {
    companion object Factory : ModelFactory<DataTest> {
        override fun newInstanceFromJson(json: String): DataTest {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return DataTest("", "")
        }
    }
}

val t: DataTest = DataTest.Factory.newInstanceFromJson("");

object UserDao {
    fun getUser(): User = User("", "", 10)
    fun saveUser(user: User) = user
}