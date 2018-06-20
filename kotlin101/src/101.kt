class Target(var id: Int) {
    fun m1() {
        println("target m1")
    }

    val t = "fixed string"
}


fun main(args: Array<String>) {
    println("Hello World!")
    var a = Target(2)
    println(a.id)
    println(a.t)


    var l = ArrayList<Int>()
    l.add(3)

    println(l)
}