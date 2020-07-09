package com.vova

trait Ball {
    def describe(): String = {
        "ball"
    }
}

trait Color extends Ball {
    override def describe(): String = {
        "blue-" + super.describe()
//        "blue-"
    }
}

trait Category extends Ball {
    override def describe(): String = {
        "foot-"+ super.describe()
    }
}

//class MyBall extends Category with Color {
class MyBall extends Color with Category {
    override def describe(): String = {
        "my ball is a " + super.describe()
    }
}

/**
 * （1）案例中的super，不是表示其父特质对象，而是表示上述叠加顺序中的下一个特质，即，MyClass中的super指代Color，Color中的super指代Category，Category中的super指代Ball。
 * （2）如果想要调用某个指定的混入特质中的方法，可以增加约束：super[]，例如super[Category].describe()。
 * 
 * 1. 列出第一个特质Category
 *      Category ----- ball
 * 2. 列出第二个特质color
 *      color ------ ball 并且叠加到第一个的前面，出现的特质不再出现
 * 3. Myclass ,放在叠加顺序的第一个
 */

object demo_026_class_2trait {
    def main(args: Array[String]): Unit = {
        println(new MyBall().describe())
    }
}


