package com.vova

object demo_020_fun_abstract {


    /**
     * 这种代码块，可视为无参函数，作为 =>Unit类型的参数值
     */
    {
        println()
    }
    
    def loop(n: Int)(op: =>Unit): Unit ={
        if (n>0){
            op
            loop(n-1)(op)
        }
    }

    def main(args: Array[String]): Unit = {
      
        loop(5){
            println("hello")
        }
    }
    

}
