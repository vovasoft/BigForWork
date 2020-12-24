package com.vova.rdd.transformation.key_value

import com.vova.rdd.transformation.value.BaseSpark
import org.apache.spark.rdd.RDD

/**
 * 内连接:
 * 在类型为(K,V)和(K,W)的 RDD 上调用，返回一个相同 key 对应的所有元素对在一起的(K,(V,W))的RDD
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_9_join extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val rdd = sc.parallelize(Array(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98)), 2)
        val rdd2 = sc.parallelize(Array(("a", "vova"), ("b", "vova"), ("a", "vova")), 1)
        val value: RDD[(String, (Int, String))] = rdd.join(rdd2, 1)

        value.collect().foreach(println)

    }
}