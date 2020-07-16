package com.vova.`match`


object demo_018_match_val {

    def describe(i:Any) = i match {
        case 5 => 1
        case true => 2
        case 6 => "this is 36"
        case _ => 3
            
    }

    /**
     * 模式匹配可以匹配所有的字面量，包括字符串，字符，数字，布尔值等等
     */

    def main(args: Array[String]): Unit = {

        println(describe(6))
    }

}
