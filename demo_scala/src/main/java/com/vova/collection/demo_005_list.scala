package com.vova.collection

object demo_005_list {

    /**
     * （1）List默认为不可变集合
     * （2）创建一个List（数据有顺序，可重复）
     * （3）遍历List
     * （4）List增加数据
     * （5）集合间合并：将一个整体拆成一个一个的个体，称为扁平化
     * （6）取指定数据
     * （7）空集合Nil
     *
     * @param args
     */
    def main(args: Array[String]): Unit = {
        //（1）List默认为不可变集合
        //（2）创建一个List（数据有顺序，可重复）
        val list: List[Int] = List(1,2,3,4,3)
        
        println(list)
        //（7）空集合Nil
        val list5 = 1::2::3::4::Nil

        //（4）List增加数据
        //（4.1）::的运算规则从右向左
        //val list1 = 5::list
        val list1 = 7::6::5::list
        //（4.2）添加到第一个元素位置
        val list2 = list.+:(5)

        //（5）集合间合并：将一个整体拆成一个一个的个体，称为扁平化
        val list3 = List(8,9)
        //val list4 = list3::list1
        val list4 = list3:::list1

        //（6）取指定数据
        println(list(0))

        //（3）遍历List
        //list.foreach(println)
        //list1.foreach(println)
        //list3.foreach(println)
        //list4.foreach(println)
        list5.foreach(println)
    }

}
