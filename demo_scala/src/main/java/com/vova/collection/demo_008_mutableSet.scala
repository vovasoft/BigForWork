package com.vova.collection

import scala.collection.mutable

object demo_008_mutableSet {

    /**
     * （1）创建可变集合mutable.Set
     * （2）打印集合
     * （3）集合添加元素
     * （4）向集合中添加元素，返回一个新的Set
     * （5）删除数据
     *
     * @param args
     */
    def main(args: Array[String]): Unit = {
        //（1）创建可变集合
        val set = mutable.Set(1,2,3,4,5,6)

        //（3）集合添加元素
        set += 8

        //（4）向集合中添加元素，返回一个新的Set
        val ints = set.+(9)
        println(ints)
        println("set2=" + set)

        //（5）删除数据
        set-=(5)

        //（2）打印集合
        set.foreach(println)
        println(set.mkString(","))
    }

}
