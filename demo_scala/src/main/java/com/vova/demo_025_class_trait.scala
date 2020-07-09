package com.vova


trait PersonTrait {

    //（1）特质可以同时拥有抽象方法和具体方法
    // 声明属性
    var name: String = _

    // 抽象属性
    var age: Int

    // 声明方法
    def eat(): Unit = {
        println("eat")
    }

    // 抽象方法
    def say(): Unit
}

trait SexTrait{
    var sex:String
}

class Teacher25 extends PersonTrait{
    override var age: Int = _

    override def say(): Unit = println("hello")
}

/**
 * 没有父类：class  类名 extends  特质1   with    特质2   with   特质3 …
 * 有父类：class  类名  extends  父类   with  特质1   with   特质2  with 特质3…
 */
object demo_025_class_trait {
    
    def main(args: Array[String]): Unit = {
        var t1 = new Teacher25
        t1.say()
        t1.eat()

//        t1.age=100;
        println(t1.age)
        
        var t2 = new Teacher25 with SexTrait {
            override var sex: String = "man"
        }
        

        println(t2.sex)
    }
    
}
