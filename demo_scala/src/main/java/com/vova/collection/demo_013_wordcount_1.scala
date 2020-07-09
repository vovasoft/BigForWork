package com.vova.collection

object demo_013_wordcount_1 {

    /**
     * 
     */

    def main(args: Array[String]): Unit = {
        /**
         * 单词计数：将集合中出现的相同的单词，进行计数，取计数排名前三的结果
          */
        
        val stringList = List("Hello Scala Hbase kafka", "Hello Scala Hbase", "Hello Scala", "Hello")
        
        val subString = stringList.flatMap(x => x.split(" "))
        
        println(subString)

        val stringToStrings = subString.groupBy(x => x)
        
        println(stringToStrings)

        // 3) 对相同的单词进行计数
        // (word, list) => (word, count)

        val wordToCountMap = stringToStrings.map(x => (x._1, x._2.size))
        println(wordToCountMap)
        
        // 4) 对计数完成后的结果进行排序（降序）
        
        val list:List[(String, Int)] = wordToCountMap.toList
        println(list)
        
        val sortList: List[(String, Int)] = list.sortBy(x=>x._2).reverse
        println(sortList)

        
        
    }

}
