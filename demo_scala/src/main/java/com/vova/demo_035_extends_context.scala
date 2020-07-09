package com.vova


/**
 * 1）语法
 * def f[A : B](a: A) = println(a) //等同于def f[A](a:A)(implicit arg:B[A])=println(a)
 * 2）说明
 * 上下问限定是将泛型和隐式转换的结合产物，以下两者功能相同，使用上下文限定[A : Ordering]之后，
 * 方法内无法使用隐式参数名调用隐式参数，需要通过implicitly[Ordering[A]]获取隐式变量。
 */
object demo_035_extends_context {

    def main(args: Array[String]): Unit = {

        def f[A:Ordering](a:A,b:A) =implicitly[Ordering[A]].compare(a,b)
//        def f[A](a: A, b: A)(implicit ord: Ordering[A]) = ord.compare(a, b)
        
        println(f(123,123))
    }

}
