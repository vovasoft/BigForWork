package com.vova

object demo_017_fun_simple {


    /**
     * 1）return可以省略，Scala会使用函数体的最后一行代码作为返回值
     * （2）返回值类型如果能够推断出来，那么可以省略
     * （3）如果函数体只有一行代码，可以省略花括号
     * （4）如果函数无参，则可以省略小括号。若定义函数时省略小括号，则调用该函数时，也需省略小括号；若定时函数时未省略，则调用时，可省可不省。
     * （5）如果函数明确声明Unit，那么即使函数体中使用return关键字也不起作用
     * （6）Scala如果想要自动推断无返回值，可以省略等号
     * （7）如果不关心名称，只关系逻辑处理，那么函数名（def）可以省略
     * （8）如果函数明确使用return关键字，那么函数返回就不能使用自行推断了，需要声明返回值类型
     */

        
    def main(args: Array[String]): Unit = {
        // 0）函数标准写法
        def f1( s : String ): String = {
            return s + " jinlian"
        }
        println(f1("Hello"))

        // 至简原则:能省则省

        //（1） return可以省略,scala会使用函数体的最后一行代码作为返回值
        def f2( s : String ): String = {
            s + " jinlian"
        }
        println(f2("Hello"))

        // 如果函数名使用return关键字，那么函数就不能使用自行推断了,需要声明返回值类型
        /*
        def f22(s:String)={
            return "jinlian"
        }
        */

        //（2）返回值类型如果能够推断出来，那么可以省略
        def f3( s : String ) = {
            s + " jinlian"
        }

        println(f3("Hello"))

        //（3）如果函数体只有一行代码，可以省略花括号
        //def f4(s:String) = s + " jinlian"
        //def f4(s:String) = "jinlian"
        def f4() = " dalang"

        // 如果函数无参，但是声明参数列表，那么调用时，小括号，可加可不加。
        println(f4())
        println(f4)

        //（4）如果函数没有参数列表，那么小括号可以省略,调用时小括号必须省略
        def f5 = "dalang"
        // val f5 = "dalang"
        
        println(f5)

        //（5）如果函数明确声明unit，那么即使函数体中使用return关键字也不起作用
        def f6(): Unit = {
            //return "abc"
            "dalang"
        }
        println(f6())

        //（6）scala如果想要自动推断无返回值,可以省略等号
        // 将无返回值的函数称之为过程
        def f7() {
            "dalang"
        }
        println(f7())

        //（7）如果不关心名称，只关系逻辑处理，那么函数名（def）可以省略
        //()->{println("xxxxx")}
        val f = (x:String)=>{"wusong"}

        // 万物皆函数 : 变量也可以是函数
        println(f("ximenqing"))

        //（8）如果函数明确使用return关键字，那么函数返回就不能使用自行推断了,需要声明返回值类型
        def f8() :String = {
            return "ximenqing"
        }
        println(f8())
        
    }
    

}
