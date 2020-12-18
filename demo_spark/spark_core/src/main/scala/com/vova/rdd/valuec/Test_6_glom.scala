package com.vova.rdd.valuec

import com.vova.rdd.valuec.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD
/**
 * 将每一个分区的元素合并成一个数组，形成新的 RDD 类型是RDD[Array[T]]
 * @author WangYang - vova
 * @version Create in 5:22 下午 2020/12/18
 */
object Test_6_glom {

    def main(args: Array[String]): Unit = {
        val arr: Array[Int] = Array(1,2,3,4,5,6)
        val rdd: RDD[Int] = sc.makeRDD(arr)

        println()
        rdd.glom().foreach(t=>{
            print(t+"\n")
            t.foreach(println)})
    }
}
