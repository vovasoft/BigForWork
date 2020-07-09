package com.vova.collection

object demo_012_commonUse {

    /**
     * 
     */

    def main(args: Array[String]): Unit = {
        /**
         * （1）获取集合长度
         * （2）获取集合大小
         * （3）循环遍历
         * （4）迭代器
         * （5）生成字符串
         * （6）是否包含
         */
        val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7)

        //（1）获取集合长度
        println(list.length)

        //（2）获取集合大小
        println(list.size)

        //（3）循环遍历
        list.foreach((x) => print(x+" "))
        println()

        //（4）迭代器
        for (elem <- list.iterator) {
            println(elem)
        }

        //（5）生成字符串
        println(list.mkString(","))

        //（6）是否包含
        println(list.contains(3))
    }

}
