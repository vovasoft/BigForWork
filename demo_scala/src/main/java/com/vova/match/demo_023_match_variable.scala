package com.vova.`match`


object demo_023_match_variable {
    case class Person(name: String, age: Int)


    /**
     * 变量声明中的模式匹配
     */

    def main(args: Array[String]): Unit = {
    val (x, y) = (1, 2)
    println(s"x=$x,y=$y")

    val Array(first, second, _*) = Array(1, 7, 2, 9)
    println(s"first=$first,second=$second")

        val Array(one, two,res,_*) = Array(1, 7, 2, 9)
        println(s"one=$one,two=$two,res=$res")

    val Person(name, age) = Person("zhangsan", 16)
    println(s"name=$name,age=$age")
        

    }

}
