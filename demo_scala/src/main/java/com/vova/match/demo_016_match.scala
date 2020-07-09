package com.vova.`match`


object demo_016_match {

    /**
     * Scala中的模式匹配类似于Java中的switch语法，但是更加强大。
     * 模式匹配语法中，采用match关键字声明，每个分支采用case关键字进行声明，
     * 当需要匹配时，会从第一个case分支开始，如果匹配成功，那么执行对应的逻辑代码，如果匹配不成功，继续执行下一个分支进行判断。
     * 如果所有case都不匹配，那么会执行case _分支，类似于Java中default语句。
     */

    def main(args: Array[String]): Unit = {
        var a: Int = 10
        var b: Int = 20
        var operator: Char = 'd'

        val unit = operator match {
            case _ =>
        }

        var result = operator match {
            case '+' => a + b
            case '-' => a - b
            case '*' => a * b
            case '/' => a / b
            case _ => "illegal"
        }

        println(result)
        println(unit)
    }

}
