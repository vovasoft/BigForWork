package com.vova.rdd.valuec

import com.vova.rdd.valuec.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

object Test_3_mapPartitionsWithIndex {

    def main(args: Array[String]): Unit = {
        val arr1: Array[Int] = Array(30, 50, 70, 60, 10, 20)
        val rdd: RDD[Int] = sc.makeRDD(arr1)
        val rdd2: RDD[(Int,Int)] = rdd.mapPartitionsWithIndex((index, t) => t.map((_ ,index)), false)

        println("getNumPartitions:"+rdd2.getNumPartitions)
        rdd2.partitions.foreach(println)

        val ints = rdd2.collect()
        println()
        ints.foreach(println)
    }
}
