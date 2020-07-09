package com.vova.collection

object demo_007_set {

    /**
     * 
     * （1）Set默认是不可变集合，数据无序
     * （2）数据不可重复
     * （3）遍历集合
     *
     * @param args
     */
    def main(args: Array[String]): Unit = {
        //（1）Set默认是不可变集合，数据无序
        val set = Set(1,2,3,4,5,6)

        //（2）数据不可重复
        val set1 = Set(1,2,3,4,5,6,3)

        //（3）遍历集合
        set.foreach(print)
        println()
        set1.foreach(print)
    }

}
