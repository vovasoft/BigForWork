package com.vova.rdd.action

import com.vova.rdd.transformation.value.BaseSpark
import org.apache.spark.HashPartitioner
import org.apache.spark.rdd.RDD

/**
 * 通过func函数聚集 RDD 中的所有元素，先聚合分区内数据，再聚合分区间数据
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_1_reduce extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val arr1: Array[Int] = Array(1,2,3,4,5)
        val arr2: Array[(Int,Int)] = Array((30, 50), (70, 60),( 10, 20))

        val rdd1: RDD[Int] = sc.makeRDD(arr1)
        val rdd2: RDD[(Int,Int)] = sc.makeRDD(arr2)

        println(rdd1.reduce(_ + _))

        val tuple: (Int, Int) = rdd2.reduce((acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2))
        println(tuple)



    }
}
