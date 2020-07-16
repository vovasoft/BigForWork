package com.vova

object demo_004_byte {


    /**
     * Byte [1]	8位有符号补码整数。数值区间为 -128 到 127
     * Short [2]	16位有符号补码整数。数值区间为 -32768 到 32767
     * Int [4]	32位有符号补码整数。数值区间为 -2147483648 到 2147483647
     */
    def main(args: Array[String]): Unit = {
        var b: Byte = 127
        b = -128
        
//        b = 128
//        b = -129


        var i: Int = 3444444;

        print(b)
        print(i)

    }

}
