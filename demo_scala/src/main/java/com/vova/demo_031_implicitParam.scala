package com.vova


object demo_031_implicitParam {

    /**
     * 普通方法或者函数可以通过implicit关键字声明隐式参数，调用该方法时，就可以传入该参数，编译器会再相应的作用域寻找符合条件的隐式值。
     * 1）说明
     * （1）同一个作用域中，相同类型的隐式值只能有一个
     * （2）编译器按照隐式参数的类型去寻找对应类型的隐式值，与隐式值的名称无关。
     * （3）隐式参数优先于默认参数
     */


    /** 隐式参数 */
    implicit val aa: String = "hello world!"

    def hello(implicit arg: String = "good bey world!"): Unit = {
        println(arg)
    }

    def main(args: Array[String]): Unit = {
        hello
    }

}
