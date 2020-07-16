package com.vova


class Person27{
    var name:String = _
    var age:Int = _
    
}

class Object27{
    var name:String = _
    var age:Int = _

}

class Teacher27 extends Person27{
    var sex:String = _
}
object demo_027_ext_type {


    /**
     * （1）obj.isInstanceOf[T]：判断obj是不是T类型。
     * （2）obj.asInstanceOf[T]：将obj强转成T类型。
     * （3）classOf获取对象的类名。
     *
     * @param args
     */
    
    def main(args: Array[String]): Unit = {
        val person = new Person27
        println(person.isInstanceOf[Person27])
        println(classOf[Person27])

        val o = new Teacher27
        o.name="abc" 
        o.age=123
        
        var t:Person27 = o.asInstanceOf[Person27]
        println(t.toString)
        
        
        
    }

}
