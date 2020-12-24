package com.vova.rdd.transformation.key_value

import com.vova.rdd.transformation.value.BaseSpark
import org.apache.spark.HashPartitioner
import org.apache.spark.rdd.RDD

/**
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_2_reduceByKey extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val arr1: Array[(Int,Int)] = Array((30, 50), (30, 60),( 10, 20))

        val rdd: RDD[(Int, Int)] = sc.makeRDD(arr1)

        //rdd 本身是kv的形式，reducebykey内容是value的内容
        val rddRes: RDD[(Int, Int)] = rdd.reduceByKey(_ * _)


        rddRes.collect().foreach(println)

    }
}
