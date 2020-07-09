package com.vova.`match`


object demo_019_match_type {


    def describe(des: Any): Any = des match {
        case des:Int => "Int"
        case des:String => "String"
        case des:List[Int] => "List[Int]"
        case des:Array[Int] => "Array[Int]"
        case des:Array[String] => "Array[String]"
        case _ => "error"
    }

    /**
     * 需要进行类型判断时，可以使用前文所学的isInstanceOf[T]和asInstanceOf[T]，也可使用模式匹配实现同样的功能。
     */

    def main(args: Array[String]): Unit = {

        //泛型擦除
        println(describe(List(1, 2, 3, 4, 5)))

        //数组例外，可保留泛型
        println(describe(Array(1, 2, 3, 4, 5, 6)))
        println(describe(Array("abc")))
    }

}
