package com.vova.rdd.transformation.value

import com.vova.rdd.transformation.value.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

/**

 * @author WangYang - vova
 * @version Create in 5:22 下午 2020/12/18
 */
object Test_7_groupby {

    def main(args: Array[String]): Unit = {
        val arr: Array[Int] = Array(1,2,3,4,5,6)
        val rdd: RDD[Int] = sc.makeRDD(arr)

        println()
        val rdd2: RDD[(Boolean, Iterable[Int])] = rdd.groupBy(t => t % 2 == 0)

        rdd2.collect().foreach(println)
    }
}
