package com.vova

object demo_032_implicitClass {

    /**
     * 在Scala2.10后提供了隐式类，可以使用implicit声明类，隐式类的非常强大，同样可以扩展类的功能，在集合中隐式类会发挥重要的作用。
     * 1）隐式类说明
     * （1）其所带的构造参数有且只能有一个
     * （2）隐式类必须被定义在“类”或“伴生对象”或“包对象”里，即隐式类不能是顶级的。
     * 
     * 
     * 
     * 1）说明
     * （1）首先会在当前代码作用域下查找隐式实体（隐式方法、隐式类、隐式对象）。（一般是这种情况）
     * （2）如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找。类型的作用域是指与该类型相关联的全部伴生对象以及该类型所在包的包对象。
     * 
     */


    implicit class MyRichInt(arg: Int) {

        def myMax(i: Int): Int = {
            if (arg < i) i else arg
        }

        def myMin(i: Int) = {
            if (arg < i) arg else i
        }
    }
    
    
    def main(args: Array[String]): Unit = {
        println(1.myMax(3))
    }

}
