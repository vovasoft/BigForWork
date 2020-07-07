package com.vova

import scala.io.StdIn

object demo_012_for {

    /**
     * 基本语法
     * for(i <- 1 to 3){
     * print(i + " ")
     * }
     * println()
     * （1）i 表示循环的变量，<- 规定to 
     * （2）i 将会从 1-3 循环，前后闭合
     *
     * @param args
     */
    
    
    def main(args: Array[String]): Unit = {

        for(i <- 1 to 3){
            print(i)
        }

        println()
        for(i <- 1 until  3){
            print(i)
        }
        
        
        //循环守卫
        println()
        for (i <- 1 to 3 if i != 2){
            print(i)
        }
        
        // 循环步长
        println()
        for(i <- 1 to 10 by 3){
            print(i)
        }

        println()
        //嵌套循环
        for( i <- 1 to 10; j <- 1 to 2){
            println(i+" , "+j)
        }
        
        println()
        //引入变量
        for( i <- 1 to 10; j = i*10){
            println(i+" , "+j)
        }
        
        println()
        //循环返回值
        val res = for(i <- 1 to 10) yield i
        println(res)
        
    }

}
