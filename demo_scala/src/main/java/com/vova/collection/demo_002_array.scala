package com.vova.collection

import scala.collection.mutable.ListBuffer;




object demo_002_array {

    def main(args: Array[String]): Unit = {
        /**
         * 定义：val arr1 = new Array[Int](10)
         * （1）new是关键字
         * （2）[Int]是指定可以存放的数据类型，如果希望存放任意数据类型，则指定Any
         * （3）(10)，表示数组的大小，确定后就不可以变化
         */
            
        //（1）数组定义
        val arr01 = new Array[Int](4)
        val arr03 = new Array[Int](4)
        
        println(arr01.hashCode())
        println(arr03.hashCode())
        println(arr01==arr03)
        println(arr01.equals(arr03))
        
        println(arr01.length) // 4
        println(arr01.mkString(","))

        //（2）数组赋值
        //（2.1）修改某个元素的值
        arr01(3) = 10
        //（2.2）采用方法的形式给数组赋值
        arr01.update(0,1)

        //（3）遍历数组
        //（3.1）查看数组
        println(arr01.mkString(","))

        //（3.2）普通遍历
        for (i <- arr01) {
            println(i)
        }

        //（3.3）简化遍历
        def printx(elem:Int): Unit = {
            println(elem)
        }
        arr01.foreach(printx)
        // arr01.foreach((x)=>{println(x)})
        // arr01.foreach(println(_))
        arr01.foreach(println)

        //（4）增加元素（由于创建的是不可变数组，增加元素，其实是产生新的数组）
        println(arr01)
        val ints: Array[Int] = 11+: arr01 :+ 5
        println(ints)
        println(ints.mkString(","))


        /**
         * 第二种方式定义数组
         * val arr1 = Array(1, 2)
         * （1）在定义数组时，直接赋值
         * （2）使用apply方法创建数组对象
         */

        var arr02 = Array(1, 3, "bobo")
        for (i <- arr02) {
            println(i)
        }
        
    }

}
