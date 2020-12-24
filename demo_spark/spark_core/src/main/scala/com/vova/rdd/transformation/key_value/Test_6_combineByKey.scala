package com.vova.rdd.transformation.key_value

import com.vova.rdd.transformation.value.BaseSpark
import org.apache.spark.rdd.RDD

/**
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_6_combineByKey extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val rdd = sc.parallelize(Array(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98)),2)

        val value: RDD[(String, (Int, Int))] = rdd.combineByKey((_, 1), (acc: (Int, Int), v) => (acc._1 + v, acc._2 + 1), (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc2._2 + acc2._2))

        value.collect().foreach(println)

    }
}
