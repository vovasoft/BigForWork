package com.vova.collection

import scala.collection.mutable.ListBuffer

object demo_006_listBuffer {

    
    def main(args: Array[String]): Unit = {
        //（1）创建一个可变集合
        val buffer = ListBuffer(1,2,3,4)

        //（2）向集合中添加数据
        buffer.+=(5)
        
        0+=:buffer

        buffer(0)=99

        //（3）打印集合数据
        buffer.foreach(println)
    }

}
