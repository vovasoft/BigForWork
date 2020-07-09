package com.vova.collection

import scala.collection.mutable

object demo_010_mutableMap {

    /**
     * （1）创建可变集合
     * （2）打印集合
     * （3）向集合增加数据
     * （4）删除数据
     * （5）修改数据
     *
     * @param args
     */
    def main(args: Array[String]): Unit = {

//        val map = mutable.Map( "a"->"3", "b"->2, "c"->3 )
//        map.put("a",33)
//        map.put("a","333")
//        
//        map.foreach(println)

        //（1）创建可变集合
        val map = mutable.Map( "a"->11, "b"->2, "c"->3 )

        //（3）向集合增加数据
        map.+=("d"->4)

        // 将数值4添加到集合，并把集合中原值1返回
        val maybeInt: Option[Int] = map.put("a", 4)
        println(maybeInt.getOrElse(0))

        //（4）删除数据
        map.-=("b", "c")

        //（5）修改数据
        map.update("d",5)

        //（2）打印集合
        map.foreach((kv)=>{println(kv)})
        map.foreach(println)
        
        
    }

}
