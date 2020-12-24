package com.vova.rdd.transformation.key_value

import com.vova.rdd.transformation.value.BaseSpark
import org.apache.spark.{HashPartitioner, Partitioner}
import org.apache.spark.rdd.RDD

/**
 *作用: 对 pairRDD 进行分区操作，如果原有的 partionRDD 的分区器和传入的分区器相同, 则返回原 pairRDD，
 * 否则会生成 ShuffleRDD，即会产生 shuffle 过程
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_1_partitionBy extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val arr1: Array[(Int,Int)] = Array((30, 50), (70, 60),( 10, 20))

        val rdd: RDD[(Int, Int)] = sc.makeRDD(arr1)

        val rddRes: RDD[(Int, Int)] = rdd.partitionBy(new HashPartitioner(4))

        rddRes.collect().foreach(println)

    }
}
