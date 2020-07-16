package com.vova

object demo_018_fun_high {


    /**
     * 定义：参数为函数的函数称为高阶函数
     */

        
    def main(args: Array[String]): Unit = {
      
        def opration(a:Int,b:Int,argFun: (Int,Int) =>Int){
            println(argFun(a, b))
        }
        
        
        def add(a:Int,b:Int): Int ={
            a+b
        }
        
        def subtract(a:Int,b:Int): Int ={
            a-b
        }
        
        opration(1,2,add)
        opration(1,2,subtract)

        /**
         * 匿名函数
         * 没有名字的函数就是匿名函数，可以直接通过函数字面量（表达式）来设置匿名函数，函数字面量定义格式如下
         */
        opration(1,2,(x,y)=>x*y)
        
        def justPrint(str:String, printFun:(String,String) =>Unit): Unit ={
            printFun(str,str)
        }
        
        justPrint("hello",(a:String,b:String)=>println("a="+a+",b="+b))
        
        
    }
    

}
