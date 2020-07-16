package com.vova

object demo_009_forceTransfer {

    
    
    def main(args: Array[String]): Unit = {

        //（1）当进行数据的从大——>小，就需要使用到强制转换
        var n1: Int = 2.5.toInt // 这个存在精度损失

        //（2）强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级
        var r1: Int = 10 * 3.5.toInt + 6 * 1.5.toInt  // 10 *3 + 6*1 = 36
        var r2: Int = (10 * 3.5 + 6 * 1.5).toInt  // 44.0.toInt = 44

        println("r1=" + r1 + " r2=" + r2)
    }

}
