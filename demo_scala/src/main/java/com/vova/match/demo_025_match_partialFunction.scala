package com.vova.`match`

object demo_025_match_partialFunction {

    /**
     * 偏函数也是函数的一种，通过偏函数我们可以方便的对输入参数做更精确的检查。
     * 例如该偏函数的输入类型为List[Int]，而我们需要的是第一个元素是0的集合，这就是通过模式匹配实现的。
     */

    def main(args: Array[String]): Unit = {
        val second: PartialFunction[List[Int], Option[Int]] = {
            case x :: y :: _ => Some(y)
        }

        println(second.applyOrElse(List(1, 2, 3), (_: List[Int]) => None))

        /**
         * 4）案例实操
         * （1）需求
         * 将该List(1,2,3,4,5,6,"test")中的Int类型的元素加一，并去掉字符串。
         */

        println(List(1, 2, 3, 4, 5, 6, "test").filter(x => x.isInstanceOf[Int]))
        println(List(1, 2, 3, 4, 5, 6, "test").filter(x => x.isInstanceOf[Int]).map(_.asInstanceOf[Int] + 1))


        List(1, 2, 3, 4, 5, 6, "test").collect{
            case x:Int => x+1
        }.foreach(print)


    }

}
