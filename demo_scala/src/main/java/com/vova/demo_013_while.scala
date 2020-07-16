package com.vova

object demo_013_while {


    def main(args: Array[String]): Unit = {
        
        
        def ifFun(): Int = {
            
            if (false){
                123
            }else{
                456
            }
            
        }
        
        var ifv = ifFun()
        
        println(ifv)
        
        def whileFun(): Int = {
            
            var time:Int = 9;
            while (0 == time){
                time=time-1
            }
            123
        }
        var whilev = whileFun()

        println(whilev)
        
        
//        
//        while (true){
//            println("haha")
//        }
        

    }
    

}
