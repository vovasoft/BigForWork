package com.vova.rdd.value_value

import com.vova.rdd.valuec.BaseSpark
import org.apache.spark.rdd.RDD

/**
 * 返回一个新的 RDD, 该 RDD 是由原 RDD 的每个元素经过函数转换后的值而组成. 就是对 RDD 中的数据做转换
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_2_subtract extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val arr1: Array[Int] = Array(30, 50, 70, 60, 10, 20)
        val arr2: Array[Int] = Array(22, 33, 70, 44, 10, 20)

        val rdd1: RDD[Int] = sc.makeRDD(arr1)
        val rdd2: RDD[Int] = sc.makeRDD(arr2)

        val rddRes: RDD[Int] = rdd1.subtract(rdd2)

        rddRes.collect().foreach(println)

    }
}
