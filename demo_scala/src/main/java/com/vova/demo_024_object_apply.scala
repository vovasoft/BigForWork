package com.vova

/**
 * Scala语言是完全面向对象的语言，所以并没有静态的操作（即在Scala中没有静态的概念）。
 * 但是为了能够和Java语言交互（因为Java中有静态概念），就产生了一种特殊的对象来模拟类对象，该对象为单例对象。
 * 若单例对象名与类名一致，则称该单例对象这个类的伴生对象，这个类的所有“静态”内容都可以放置在它的伴生对象中声明。
 */


object demo_024_object_apply {
    def main(args: Array[String]): Unit = {

        //（1）通过伴生对象的apply方法，实现不使用new关键字创建对象。
        val p1 = Person24()
        println("p1.name=" + p1.name)

        val p2 = Person24("bobo")
        println("p2.name=" + p2.name)

//        val p3 = new Person24("vova")
//        println("p3.name=" + p3.name)
    }
}

//（2）如果想让主构造器变成私有的，可以在()之前加上private
class Person24 private(cName: String) {
    var name: String = cName
}

object Person24 {

    def apply(): Person24 = {
        println("apply空参被调用")
        new Person24("xx")
    }

    def apply(name: String): Person24 = {
        println("apply有参被调用")
        new Person24(name)
    }
}
