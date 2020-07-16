package com.vova

object demo_007_unit {


    /**
     * Unit	表示无值，和其他语言中void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值，写成()。
     * Null	null , Null 类型只有一个实例值null
     * Nothing	Nothing类型在Scala的类层级的最低端；它是任何其他类型的子类型。
     * 当一个函数，我们确定没有正常的返回值，可以用Nothing来指定返回类型，这样有一个好处，就是我们可以把返回的值（异常）赋给其它的函数或者变量（兼容性）
     **/

    def main(args: Array[String]): Unit = {

//        var n1: Int = null // 错误
//        val n2: Int = null // 错误
//        println("n1:" + n1)
//        println("n2:" + n2)

        var cat = new Cat();
        cat = null	// 正确
        
        def fun(): Unit = {
            println("this is fun")
        }
        
        fun()
        
        def testNothing() : Nothing = {
            throw  new RuntimeException("wahahahha")
        }
        
        testNothing()

    }

    class Cat()

}
