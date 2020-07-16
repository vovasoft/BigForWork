package com.vova

import scala.io.StdIn

object demo_011_if {

    
    
    def main(args: Array[String]): Unit = {

        println("请输入成绩")
        val grade = StdIn.readInt()

        
        if (grade == 100){
            println("成绩为100分，奖励一辆BM")
        }else if (grade > 80 && grade <= 90){
            println("奖励一台iphone")
        }else{
            println("什么奖励也没有")
        }


        var flag:Boolean = true
        var result = if(flag) 1 else 0
        println(result)
    }

}
