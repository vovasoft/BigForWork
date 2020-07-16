package com.vova.collection;

import scala.collection.mutable.ListBuffer;

/**
 * （1）Scala的集合有三大类：序列Seq、集Set、映射Map，所有的集合都扩展自Iterable特质。
 * （2）对于几乎所有的集合类，Scala都同时提供了可变和不可变的版本，分别位于以下两个包
 * 
 * 不可变集合：scala.collection.immutable
 * 可变集合：  scala.collection.mutable
 * @author WangYang - vova
 * @version Create in 4:37 下午 2020/7/8
 */


object demo_001_test {

    def main(args: Array[String]): Unit = {
        //不可变List
        val immutableList: List[Int] = List(1, 2, 3, 4, 5)

        //对不可变List进行修改，在头部添加一个元素0
        val newImmutableList: List[Int] = 0 +: immutableList

        println(immutableList)
        println(newImmutableList)
        println(immutableList.hashCode())
        println(newImmutableList.hashCode())


        //可变List
        val mutableList: ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 5)

        //对可变List进行修改，在头部添加一个元素0
        val newMutableList: ListBuffer[Int] = 0 +=: mutableList
        

        println(mutableList)
        println(newMutableList)

        println(mutableList.hashCode())
        println(newMutableList.hashCode())
    }
   
}
