package com.vova

object demo_002_var {

    def main(args: Array[String]): Unit = {

//        var | val 变量名 [: 变量类型] = 变量值
//        （1）声明变量时，类型可以省略（编译器自动推导，即类型推导）
//        （2）类型确定后，就不能修改，说明Scala是强数据类型语言。
//        （3）变量声明时，需要初始值
        var name = "vova";
        var age =13
        
        printf("voav"+name+", age"+age)
        
        
    }
}
