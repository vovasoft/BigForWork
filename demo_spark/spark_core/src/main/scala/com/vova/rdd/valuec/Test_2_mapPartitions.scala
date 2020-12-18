package com.vova.rdd.valuec

import org.apache.spark.rdd.RDD

/**
 * 类似于map(func), 但是是独立在每个分区上运行
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_2_mapPartitions extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val arr1: Array[Int] = Array(30, 50, 70, 60, 10, 20)
        val rdd: RDD[Int] = sc.makeRDD(arr1)
        val rdd2: RDD[Int] = rdd.mapPartitions(t=> t.map(_ * 2), false)

        println("getNumPartitions:"+rdd2.getNumPartitions)
        rdd2.partitions.foreach(println)

        val ints = rdd2.collect()
        ints.foreach(println)
    }



}
