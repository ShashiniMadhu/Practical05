package Prac05

import scala.io.StdIn.readLine

object Quec01 {
  def getProductList(): List[String] = {
    var productList=List[String]()
    var name=""

    println("Enter name of products(Enter 'done' to stop adding):")
    while(name != "done"){
      if (name.nonEmpty)
        productList = productList :+ name
      name=readLine()

    }
    productList
  }

  def printProductList(productList:List[String]): Unit = {
    for(i<-productList.indices){
      println(s"${i+1}.${productList(i)}")
    }
  }

  def getTotalProducts(productList:List[String]): Unit = {
    val count=productList.length;
    println(s"You have added $count number of items to list")
  }

  def main(args:Array[String]): Unit = {
    val product=getProductList()
    println("***PRODUCT LIST***")
    printProductList(product)
    getTotalProducts(product)
  }

}
