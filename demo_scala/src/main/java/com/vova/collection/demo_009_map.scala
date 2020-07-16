package com.vova.collection

import scala.collection.mutable

object demo_009_map {

    /**
     * （1）创建不可变集合Map
     * （2）循环打印
     * （3）访问数据
     * （4）如果key不存在，返回0
     *
     * @param args
     */
    def main(args: Array[String]): Unit = {
        // Map
        //（1）创建不可变集合Map
        val map = Map( "a"->1, "b"->2, "c"->3 )

        //（3）访问数据
        for (elem <- map.keys) {
            // 使用get访问map集合的数据，会返回特殊类型Option(选项):有值（Some），无值(None)
            println(elem + "=" + map.get(elem).get)
        }

        //（4）如果key不存在，返回0
        println(map.get("d").getOrElse(0))
        println(map.getOrElse("d", 0))

        //（2）循环打印
        map.foreach((kv)=>{println(kv)})
    }

}
