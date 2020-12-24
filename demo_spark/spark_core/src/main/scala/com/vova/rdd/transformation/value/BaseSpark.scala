package com.vova.rdd.transformation.value

import org.apache.spark.{SparkConf, SparkContext}

class BaseSpark {
    val conf: SparkConf = new SparkConf().setMaster("local[4]").setAppName("vovaTest")
    val sc: SparkContext = new SparkContext(conf)

}
