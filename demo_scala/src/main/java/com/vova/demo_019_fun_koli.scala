package com.vova

object demo_019_fun_koli {


    /**
     * 函数柯里化：将一个接收多个参数的函数转化成一个接受一个参数的函数过程，可以简单的理解为一种特殊的参数列表声明方式。
     * 闭包：就是一个函数和与其相关的引用环境（变量）组合的一个整体(实体)
     */

    //柯里化
    val sum = (x: Int, y: Int, z: Int) => x + y + z

    val sum1 = (x: Int) => {
        y: Int => {
            z: Int => {
                x + y + z
            }
        }
    }

    val sum2 = (x: Int) => (y: Int) => (z: Int) => x + y + z

    def sum3(x: Int)(y: Int)(z: Int) = x + y + z
        
    def main(args: Array[String]): Unit = {
      
        //闭包
        var x: Int = 10
        //闭包
        def f(x: Int, y: Int): Int = {
            x + y
        }

        println(f(1, 2))
        
        //柯里化
        println(sum(1, 2, 3))
        println(sum1(1)(2)(3))
        println(sum2(1)(2)(3))
        println(sum3(1)(2)(3))

        val intToIntToInt = sum1(1)
        
        println(intToIntToInt)
        println(intToIntToInt(2)(4))
    }
    

}
