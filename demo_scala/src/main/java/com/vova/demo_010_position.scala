package com.vova

object demo_010_position {

    
    
    def main(args: Array[String]): Unit = {

        // 测试：1000 << 1 =>10000
        var n1 :Int =8
        println(n1)
        n1 = n1 << 1
        println(n1)
        n1 = n1 >> 1
        println(n1)
        
        n1 = -1
        n1 = n1 >>> 63
        println(n1)

        n1 = -1
        n1 = n1 >>> 62
        n1 = n1 >>> 1
        
        println(n1)

        n1 = -1
        n1 = n1 >>> 63
        n1 = n1 >>> 1
        println(n1)
        
        n1 = -1
        n1 = n1 >>> 64
        println(n1)
    }

}
