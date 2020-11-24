



object ArrayDemo {


    def main(args: Array[String]): Unit = {
        val arr1: Array[Int] = Array(30, 50, 70, 60, 10, 20)

        val a1 = arr1.slice(2, 3)

        a1.foreach(println)

        val a2 = arr1.slice(3,4)

        a2.foreach(println)

    }

}
