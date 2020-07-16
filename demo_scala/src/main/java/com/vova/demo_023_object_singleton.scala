package com.vova

/**
 * Scala语言是完全面向对象的语言，所以并没有静态的操作（即在Scala中没有静态的概念）。
 * 但是为了能够和Java语言交互（因为Java中有静态概念），就产生了一种特殊的对象来模拟类对象，该对象为单例对象。
 * 若单例对象名与类名一致，则称该单例对象这个类的伴生对象，这个类的所有“静态”内容都可以放置在它的伴生对象中声明。
 */


object demo_023_object_singleton {
    //（1）伴生对象采用object关键字声明
    object Person23 {
        var country: String = "China"
    }

    //（2）伴生对象对应的类称之为伴生类，伴生对象的名称应该和伴生类名一致。
    class Person23 {
        var name: String = "bobo"
    }


    def main(args: Array[String]): Unit = {
        println(Person23.country)

        println(new Person23().name)
    }

}
