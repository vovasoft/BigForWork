package com.vova.rdd.valuec

import com.vova.rdd.valuec.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

object Test_5_filter {

    def main(args: Array[String]): Unit = {
        val arr: Array[Int] = Array(1,2,3,4,5,6)
        val rdd: RDD[Int] = sc.makeRDD(arr)

        println()
        rdd.filter(t=>t<4).foreach(println)
    }
}
