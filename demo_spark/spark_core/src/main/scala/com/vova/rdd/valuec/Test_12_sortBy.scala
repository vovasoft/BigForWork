package com.vova.rdd.valuec

import com.vova.rdd.valuec.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

/**

 * @author WangYang - vova
 * @version Create in 5:22 下午 2020/12/18
 */
object Test_12_sortBy {

    def main(args: Array[String]): Unit = {

        val rdd: RDD[Int] = sc.parallelize(Array(1,3,3,344,5,6,67,7,75,4,34,90))

        rdd.sortBy(t=>t,false).collect().foreach(println)
        rdd.sortBy(t=>t,true).collect().foreach(println)






    }
}
