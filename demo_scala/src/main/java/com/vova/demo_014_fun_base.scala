package com.vova

object demo_014_fun_base {


    /**
     * 1）核心概念
     * （1）为完成某一功能的程序指令（语句）的集合，称为函数。
     * （2）类中的函数称之方法。
     *
     * @param args
     */


    def main(args: String): Unit = {
        println("123")
    }
        
    def main(args: Array[String]): Unit = {
        
        def functonPrint(arg :String): Unit={
            println(arg)
        }
        
        functonPrint("123")

        /**
         * （1）Scala语言的语法非常灵活，可以在任何的语法结构中声明任何的语法
         * （2）函数没有重载和重写的概念；方法可以进行重载和重写
         * （3）scala中函数可以嵌套定义
         */
        

    }
    

}
