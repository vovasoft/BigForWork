package com.vova


class MyRichInt(val self: Int) {
    def myMax(i: Int): Int = {
        if (self < i) i else self
    }

    def myMin(i: Int): Int = {
        if (self < i) self else i
    }
}

object demo_030_implicitFunction {

    /**
     * 1）说明
     * 隐式转换可以再不需改任何代码的情况下，扩展某个类的功能。
     *
     * @param args
     */
    def main(args: Array[String]): Unit = {
        implicit def convert(arg: Int): MyRichInt = {
            new MyRichInt(arg)
        }

        def main(args: Array[String]): Unit = {
            println(2.myMax(6))
        }
    }

}
