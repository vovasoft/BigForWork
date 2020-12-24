package com.vova.rdd.transformation.key_value

import com.vova.rdd.transformation.value.BaseSpark
import org.apache.spark.rdd.RDD

/**
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_3_groupByKey extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val arr1: Array[(Int,Int)] = Array((30, 50), (30, 60),( 10, 20))

        val rdd: RDD[(Int, Int)] = sc.makeRDD(arr1)

        val rddRes: RDD[(Int, Iterable[Int])] = rdd.groupByKey(1)


        rddRes.collect().foreach(println)

    }
}
