package com.vova

object demo_021_fun_lazy {


    def sum(n1: Int, n2: Int): Int = {
        println("sum被执行。。。")
        return n1 + n2
    }
    

    def main(args: Array[String]): Unit = {
        lazy val res = sum(10, 30)
        println("----------------")
        println("res=" + res)


        var res2 = sum(10, 30)
        println("----------------")
        println("res2=" + res)
    }
    

}
