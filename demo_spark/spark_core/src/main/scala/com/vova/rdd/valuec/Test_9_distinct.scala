package com.vova.rdd.valuec

import com.vova.rdd.valuec.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

/**

 * @author WangYang - vova
 * @version Create in 5:22 下午 2020/12/18
 */
object Test_9_distinct {

    def main(args: Array[String]): Unit = {

        val rdd: RDD[Int] = sc.makeRDD(Array(1,2,3,4,4,4,5,65,6,6,7,7,7))

        rdd.distinct().collect().foreach(println)

    }
}
