package com.vova

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test_2_CreateRDD {

    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("vova").setMaster("local[*]")
        var sc: SparkContext = new SparkContext(conf)

        val arr1: Array[Int] = Array(30, 50, 70, 60, 10, 20)

//        val rdd1: RDD[Int] = sc.parallelize(arr1, 3)
        val rdd1: RDD[Int] = sc.parallelize(arr1)


        //        rdd1.collect().foreach(println)
        //
        //        rdd1.map(_*2).collect().foreach(println)

        //每个分区执行一次
        val res1: RDD[Int] = rdd1.mapPartitions(it => {
            println(123)
            it.map(_ * 2)
        })
        println("=========================================")
        val res2: RDD[(Int, Int)] = rdd1.mapPartitionsWithIndex((index, it) => {
            it.map(x => (index, x))
        })

        res1.collect().foreach(println)
        res2.collect().foreach(println)

        sc.stop()


    }

}
