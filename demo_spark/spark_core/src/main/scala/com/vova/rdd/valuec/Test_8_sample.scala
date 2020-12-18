package com.vova.rdd.valuec

import com.vova.rdd.valuec.Test_2_mapPartitions.sc
import org.apache.spark.rdd.RDD

/**
    1.以指定的随机种子随机抽样出比例为fraction的数据，(抽取到的数量是: size * fraction). 需要注意的是得到的结果并不能保证准确的比例.
    2.withReplacement表示是抽出的数据是否放回，true为有放回的抽样，false为无放回的抽样. 放回表示数据有可能会被重复抽取到, false 则不可能重复抽取到. 如果是false, 则fraction必须是:[0,1], 是 true 则大于等于0就可以了.
    3.seed用于指定随机数生成器种子。 一般用默认的, 或者传入当前的时间戳
 * @author WangYang - vova
 * @version Create in 5:22 下午 2020/12/18
 */
object Test_8_sample {

    def main(args: Array[String]): Unit = {

        val rdd: RDD[Int] = sc.parallelize(1 to 100)

        rdd.sample(true, 2).collect().foreach(println)

    }
}
