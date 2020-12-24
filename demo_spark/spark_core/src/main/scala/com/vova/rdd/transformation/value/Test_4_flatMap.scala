package com.vova.rdd.transformation.value

import com.vova.rdd.transformation.value.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

object Test_4_flatMap {

    def main(args: Array[String]): Unit = {
        val tuples: Array[(Int, Int)] = Array((30, 50), (70, 60), (10, 20))
        val rdd: RDD[(Int, Int)] = sc.makeRDD(tuples)

        val value: RDD[Int] = rdd.flatMap(x => Array(x._1,x._2))

        value.foreach(println)
    }
}
