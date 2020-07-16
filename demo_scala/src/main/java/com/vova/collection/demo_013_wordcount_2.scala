package com.vova.collection

object demo_013_wordcount_2 {

    /**
     * 
     */

    def main(args: Array[String]): Unit = {
        
        /**
         * 单词计数：将集合中出现的相同的单词，进行计数，取计数排名前三的结果
         * 方式一
         */
        val tupleList = List(("Hello Scala Spark World ", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))
        val chars = tupleList.flatMap(x => x._1.split(" "))
        println(chars)
        val tuples = chars.groupBy(x => x).map(x => (x._1, x._2.size)).toList.sortBy(x => x._2).reverse
        println(tuples)
        
        
        
    }

}
