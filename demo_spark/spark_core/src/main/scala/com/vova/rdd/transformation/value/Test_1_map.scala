package com.vova.rdd.transformation.value

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * 返回一个新的 RDD, 该 RDD 是由原 RDD 的每个元素经过函数转换后的值而组成. 就是对 RDD 中的数据做转换
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_1_map extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val arr1: Array[Int] = Array(30, 50, 70, 60, 10, 20)
        val rdd: RDD[Int] = sc.makeRDD(arr1)
        val map: RDD[(Int, Int)] = rdd.map((_, 1))

        map.foreach(t => println(t._1,t._2))
    }
}
