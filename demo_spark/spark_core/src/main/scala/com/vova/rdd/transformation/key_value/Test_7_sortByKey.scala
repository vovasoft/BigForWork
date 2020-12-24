package com.vova.rdd.transformation.key_value

import com.vova.rdd.transformation.value.BaseSpark
import org.apache.spark.rdd.RDD

/**
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_7_sortByKey extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val rdd = sc.parallelize(Array(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98)), 2)

        rdd.sortByKey().collect().foreach(println)



    }
}
