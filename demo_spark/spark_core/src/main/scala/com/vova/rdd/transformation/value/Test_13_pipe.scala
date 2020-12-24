package com.vova.rdd.transformation.value

import com.vova.rdd.transformation.value.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

/**

 * @author WangYang - vova
 * @version Create in 5:22 下午 2020/12/18
 */
object Test_13_pipe {

    def main(args: Array[String]): Unit = {

        val rdd: RDD[Int] = sc.parallelize(Array(1,3,3))

        rdd.pipe("echo").collect().foreach(println);



        



    }
}
