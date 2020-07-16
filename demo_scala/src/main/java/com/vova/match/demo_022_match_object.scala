package com.vova.`match`


object demo_022_match_object {
    

    /**
     * 匹配对象及样例类。
     * 匹配对象的案例使用样例类会节省大量代码
     * 
     * （1）语法：
     * case class Person (name: String, age: Int)
     * （2）说明
     * 样例类仍然是类，和普通类相比，只是其自动生成了伴生对象，并且伴生对象中自动提供了一些常用的方法，如apply、unapply、toString、equals、hashCode和copy。
     * 样例类是为模式匹配而优化的类，因为其默认提供了unapply方法，因此，样例类可以直接使用模式匹配，而无需自己实现unapply方法。
     * 构造器中的每一个参数都成为val，除非它被显式地声明为var（不建议这样做）
     */
    
//    case class User(name: String, age: Int)

    
    class User(val name: String, val age: Int)

    object User {

        def apply(name: String, age: Int): User = new User(name, age)

        def unapply(user: User): Option[(String, Int)] = {
            if (user == null)
                None
            else
                Some(user.name, user.age)
        }
    }

    def main(args: Array[String]): Unit = {
        val user: User = User("zhangsan", 11)
        val result = user match {
            case User("zhangsan", 11) => "yes"
            case _ => "no"
        }

        println(result)
        

    }

}
