package com.vova.collection

object demo_012_commonUse {

    /**
     * 
     */

    def main(args: Array[String]): Unit = {
        /**
         * （1）获取集合长度
         * （2）获取集合大小
         * （3）循环遍历
         * （4）迭代器
         * （5）生成字符串
         * （6）是否包含
         */
        var list: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
        var lis2: List[String] = List()
        
        lis2 = lis2:+ "123"
        lis2.foreach(println)
        

        //（1）获取集合长度
        println(list.length)

        //（2）获取集合大小
        println(list.size)

        //（3）循环遍历
        list.foreach((x) => print(x+" "))
        println()

        //（4）迭代器
        for (elem <- list.iterator) {
            println(elem)
        }

        //（5）生成字符串
        println(list.mkString(","))

        //（6）是否包含
        println(list.contains(3))

        /**
         * （1）获取集合的头head
         * （2）获取集合的尾（不是头就是尾）tail
         * （3）集合最后一个数据 last
         * （4）集合初始数据（不包含最后一个）
         * （5）反转
         * （6）取前（后）n个元素
         * （7）去掉前（后）n个元素
         * （8）并集
         * （9）交集
         * （10）差集
         * （11）拉链
         * （12）滑窗
         */

        list= List(1, 5, -3, 4, 2, -7, 6)

        //（1）求和
        println(list.sum)

        //（2）求乘积
        println(list.product)

        //（3）最大值
        println(list.max)

        //（4）最小值
        println(list.min)

        //（5）排序
        // （5.1）按照元素大小排序
        println(list.sortBy(x => x))

        // （5.2）按照元素的绝对值大小排序
        println(list.sortBy(x => x.abs))

        // （5.3）按元素大小升序排序
        println(list.sortWith((x, y) => x < y))

        // （5.4）按元素大小降序排序
        println(list.sortWith((x, y) => x > y))


        /**
         * （1）过滤
         * （2）转化/映射
         * （3）扁平化
         * （4）扁平化+映射 注：flatMap相当于先进行map操作，在进行flatten操作
         * （5）分组
         * （6）简化（规约）
         * （7）折叠
         */

        list  = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
        val wordList: List[String] = List("hello world", "hello atguigu", "hello scala")

        //（1）过滤
        println(list.filter(x => x % 2 == 0))

        //（2）转化/映射
        println(list.map(x => x + 1))

        //（3）扁平化
        println(nestedList.flatten)

        //（4）扁平化+映射 注：flatMap相当于先进行map操作，在进行flatten操作
        println(wordList.flatten)
        println(wordList.flatten(x => x+"110"))
        println(wordList.flatMap(x => x))
        println(wordList.flatMap(x => x.split(" ")))

        //（5）分组
        println(list.groupBy(x => x % 2))


        /**
         * reduce
         */
        list = List(1,2,3,4)

        // 将数据两两结合，实现运算规则
        var i: Int = list.reduce((x, y) => x - y)
        println("i = " + i)

        // 从源码的角度，reduce底层调用的其实就是reduceLeft
        //val i1 = list.reduceLeft((x,y) => x-y)

        // ((4-3)-2-1) = -2
        val i2 = list.reduceRight((x,y) => x-y)
        println(i2)


        /**
         * Fold折叠：化简的一种特殊情况。
         */
        println("Fold折叠：化简的一种特殊情况。")
        list = List(1,2,3,4)

        // fold方法使用了函数柯里化，存在两个参数列表
        // 第一个参数列表为 ： 零值（初始值）
        // 第二个参数列表为：

        // fold底层其实为foldLeft
        i = list.foldLeft(1)((x,y)=>x+y)
        println(i)
        i = list.foldLeft(1)((x,y)=>x*y)
        println(i)
        i = list.fold(2)((x,y)=>x*y)
        println(i)

        val i1 = list.foldRight(1)((x,y)=>x-y)

        println(i1)
    }

}
