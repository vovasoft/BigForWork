package com.vova.rdd.transformation.key_value

import com.vova.rdd.transformation.value.BaseSpark
import org.apache.spark.rdd.RDD

/**
 *
 * @author WangYang - vova
 * @version Create in 3:56 下午 2020/12/18
 */

object Test_4_aggregateByKey extends BaseSpark {

    def main(args: Array[String]): Unit = {

        val rdd = sc.parallelize(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)),3)

        rdd.aggregateByKey(Int.MinValue)(math.max(_,_),_+_).collect().foreach(println)

    }
}
