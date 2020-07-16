package com.vova.collection

import scala.collection.mutable

object demo_014_queue {

    /**
     * 
     */

    def main(args: Array[String]): Unit = {
        
       val queue = new mutable.Queue[String]()
        queue.enqueue("a","b","c")

        println(queue.dequeue())
        println(queue.dequeue())
        println(queue.dequeue())
        println(queue.dequeue())
        
    }

}
