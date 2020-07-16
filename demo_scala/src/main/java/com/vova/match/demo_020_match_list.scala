package com.vova.`match`


object demo_020_match_list {
    

    /**
     * 需要进行类型判断时，可以使用前文所学的isInstanceOf[T]和asInstanceOf[T]，也可使用模式匹配实现同样的功能。
     */

    def main(args: Array[String]): Unit = {
        //list是一个存放List集合的数组
        //请思考，如果要匹配 List(88) 这样的只含有一个元素的列表,并原值返回.应该怎么写
        for (list <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0), List(88))) {

            val result = list match {

                case List(0) => "0" //匹配List(0)
                case List(x, y) => x + "," + y //匹配有两个元素的List
                case List(0, _*) => "0 ..."
                case _ => "something else"
            }

            println(result)
        }


        val list: List[Int] = List(1, 2, 5, 6, 7)

        list match {
            case first :: second :: rest => println(first + "-" + second + "-" + rest)
            case first :: second :: three:: rest => println(first + "-" + second + "-" + three +"-"+rest)
            case _ => println("something else")
        }

    }

}
