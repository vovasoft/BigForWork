package com.vova.collection

import scala.collection.mutable

object demo_015_parmap {

    /**
     * Scala为了充分使用多核CPU，提供了并行集合（有别于前面的串行集合），用于多核环境的并行计算。
     */

    def main(args: Array[String]): Unit = {

        println((0 to 100))
//        val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}
//        println(result1)
        val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}
        println(result2)
    }

}
