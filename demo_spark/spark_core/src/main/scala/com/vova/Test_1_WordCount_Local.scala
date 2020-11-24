package com.vova

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test_1_WordCount_Local {

    def main(args: Array[String]): Unit = {

        /** 1 创建一个sparkcontext */

        val conf: SparkConf = new SparkConf().setMaster("local[4]").setAppName("vovaTest")
        val cs: SparkContext = new SparkContext(conf)

        /** 2 从数据源得到一个rdd */
        val lineRDD: RDD[String] = cs.textFile(args(0))

        /** 3 对rdd各种转换 */
        val resultRDD: RDD[(String, Int)] = lineRDD.flatMap(_.split("\\W")).map((_, 1)).reduceByKey(_ + _)


        /** 4 执行一个行动算子 */
        val wordCount: Array[(String, Int)] = resultRDD.collect()
        wordCount.foreach(println)

        /** 5 关闭sc */
        cs.stop()


    }


}
