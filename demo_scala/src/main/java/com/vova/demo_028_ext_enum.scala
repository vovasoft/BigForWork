package com.vova

// 枚举类
object Color28 extends Enumeration {
    val RED = Value(1, "red")
    val YELLOW = Value(2, "yellow")
    val BLUE = Value(3, "blue")
}
object Color28_1 extends Enumeration {
    val RED = Value(10,"red")
    val YELLOW =Value("red")
    val BLUE = Value( "blue")
}

// 应用类
object Test20 extends App {
    println("xxxxxxxxxxx");
}

object demo_028_ext_enum {


    /**
     * 说明
     * 枚举类：需要继承Enumeration
     * 应用类：需要继承App
     *
     * @param args
     */
    
    def main(args: Array[String]): Unit = {
        println(Color28.BLUE)
        println(Color28.BLUE.id)
        
        println(Color28_1.BLUE)
        println(Color28_1.BLUE.id)
        
    }

}
