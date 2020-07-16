package com.vova.collection

import scala.collection.mutable.ArrayBuffer
;


object demo_003_arrayBuffer {

    def main(args: Array[String]): Unit = {
        /**
         * 定义变长数组
         * val arr01 = ArrayBuffer[Any](3, 2, 5)
         * （1）[Any]存放任意数据类型
         * （2）(3, 2, 5)初始化好的三个元素
         * （3）ArrayBuffer需要引入scala.collection.mutable.ArrayBuffer
         */
        //（1）创建并赋值可变数组
        val arr01 = ArrayBuffer[Any](1, 2, 3)
        val arr02 = ArrayBuffer[Any](1, 2, 3)
        
        println(arr01.equals(arr02))
        println(arr01==arr02)

        //（2）遍历数组
        for (i <- arr01) {
            println(i)
        }
        println(arr01.length) // 3
        println("arr01.hash=" + arr01.hashCode())
        println("arr02.hash=" + arr02.hashCode())
        

        //（3）增加元素
        //（3.1）追加数据
        arr01.+=(4)
        println("arr01.hash=" + arr01.hashCode())
        arr01+=(4)
        //（3.2）向数组最后追加数据
        arr01.append(5,6)
        //（3.3）向指定的位置插入数据
        //        arr01.insert(0,7,8)
        println("arr01.hash=" + arr01.hashCode())

        //（4）修改元素
        arr01(1) = 9 //修改第2个元素的值
        println(arr01.mkString(","))
        88+=:arr01+=99
        println(arr01.mkString(","))
        println("--------------------------")

        for (i <- arr01) {
            print(i)
        }
        println(arr01.length) // 5
            
     
    }

}
