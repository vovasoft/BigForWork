package com.vova.rdd.transformation.value

import com.vova.rdd.transformation.value.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

/**

 * @author WangYang - vova
 * @version Create in 5:22 下午 2020/12/18
 */
object Test_10_coalesce {

    def main(args: Array[String]): Unit = {

        val rdd: RDD[Int] = sc.parallelize(0 to 100, 5)
        println(rdd.getNumPartitions)
        println(rdd.coalesce(2).getNumPartitions)
        println(rdd.getNumPartitions)

    }
}
