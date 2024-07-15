package Prac05

import scala.io.StdIn.readLine

case class Book(
                 title: String,
                 author: String,
                 isbn: String
               )
object Quec02 {

  var library:Set[Book]=Set(
    Book("Ben Hur","Lewis wallace","1"),
    Book("Animal farm","George Islam","2"),
    Book("Utopia","Thomas Moor","3")
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Book added: ${book.title} by ${book.author} with ISBN:${book.isbn}")
  }

  def removeBook(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"Book removed: ${book.title} by ${book.author}")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def checkBookAvailability(isbn: String): Unit = {
    if (library.exists(_.isbn == isbn)) {
      println(s"Book with ISBN $isbn is available.")
    } else {
      println(s"No book found with ISBN: $isbn")
    }
  }

  def displayLibrary(): Unit = {
    println("Current library collection:")
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def searchBookByTitle(title: String): Unit = {
    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with title: $title")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
      println(s"No books found by author: $author")
    }
  }

  def libraryManagement(library:Set[Book]): Unit ={
    println()
    println("1.Add a book to library")
    println("2.remove book from library")
    println("3.Cheack available of a book by ISBN")
    println("4.Display current library collection")
    println("5.Search book by title")
    println("6.Display all books by a specific author")
    println("Enter the number of option,what you need to do:(-1 to exit)")
    var input=readLine()
    println()
    input match{

      case "1"=>
        println("Enter book title:")
        val title=readLine()
        println("Enter book author")
        val author=readLine()
        println("Enter book ISBN")
        val isbn=readLine()
        addBook(Book(title,author,isbn))

      case "2"=>
        println("Enter book ISBN")
        val isbn=readLine()
        removeBook(isbn)

      case "3"=>
        println("Enter book ISBN")
        val isbn=readLine()
        checkBookAvailability(isbn)

      case "4"=>
        displayLibrary()

      case "5"=>
        println("Enter book title")
        val title=readLine()
        searchBookByTitle(title)

      case "6"=>
        println("Enter book author")
        val author=readLine()
        displayBooksByAuthor(author)

      case _=>
        println("Exit")
        System.exit(0)//exit the program
    }
  }

  def main(args:Array[String]): Unit = {
    while (true) {
      libraryManagement(library)
    }
  }


}

