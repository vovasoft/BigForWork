package com.vova.collection

object demo_011_tuple {

    /**
     * 元组也是可以理解为一个容器，可以存放各种相同或不同类型的数据。说的简单点，就是将多个无关的数据封装为一个整体，称为元组。
     * 注意：元组中最大只能有22个元素。
     * 2）案例实操
     * （1）声明元组的方式：(元素，元素2，元素3)
     * （2）访问元组
     */

    def main(args: Array[String]): Unit = {
        //（1）声明元组的方式：(元素，元素2，元素3)
        val tuple: (Int, String, Boolean) = (40,"bobo",true)

        //（2）访问元组
        //（2.1）通过元素的顺序进行访问，调用方式：_顺序号
        println(tuple._1)
        println(tuple._3)
        println(tuple._2)

        //（2.2）通过索引访问数据
        println(tuple.productElement(0))

        //（2.3）通过迭代器访问数据
        for (elem <- tuple.productIterator) {
            println(elem)
        }

        //（3）Map中的键值对其实就是元组,只不过元组的元素个数为2，称之为对偶
        val map = Map("a"->1, "b"->2, "c"->3)

        map.foreach(tuple=>{println(tuple._1 + "=" + tuple._2)})
    }

}
