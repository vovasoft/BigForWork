package com.vova.`match`


object demo_017_match_abs {

    /**
     * 如果想要表达匹配某个范围的数据，就需要在模式匹配中增加条件守卫
     */

    def main(args: Array[String]): Unit = {
        
        
        def abs(x: Int) = x match {
            case i: Int if i >= 0 => i
            case j: Int if j < 0 => -j
            case _ => "type illegal"
        }

        println(abs(-5))

    }

}
