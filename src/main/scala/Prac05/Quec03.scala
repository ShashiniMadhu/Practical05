package Prac05

import scala.io.StdIn.readLine

object Quec03 {
  def fibonacci(n: Int): Int = n match {
    case 0 => 0
    case x if x == 1 => 1
    case _ => fibonacci(n - 1) + fibonacci(n - 2)
  }

  def fibonacciSeq(n: Int): Unit = {
    for (i <- 0 until n) {
      println(fibonacci(i))
    }
  }

  def main(args:Array[String]): Unit = {
    println("Enter a non-negative integer:")
    val input = readLine()
    //potential error handling
    //if any exception in try block,catch block will catch it
    try {
      val n = input.toInt
      if (n >= 0) {
        println(s"Fibonacci sequence up to $n:")
        fibonacciSeq(n)
      } else {
        println("Please enter a non-negative integer.")
      }
    } catch {
      case _: NumberFormatException =>
        println("Invalid input. Please enter an integer.")
    }
  }

}
