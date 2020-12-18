package com.vova.rdd.key_value

import com.vova.rdd.valuec.BaseSpark
import org.apache.spark.rdd.RDD

/**
 *
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_1_partitionBy extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val arr1: Array[(Int,Int)] = Array((30, 50), (70, 60),( 10, 20))

        val rdd: RDD[(Int, Int)] = sc.makeRDD(arr1)


        rddRes.collect().foreach(println)

    }
}
