case class Book(title: String, author: String, isbn: String)

object LibraryManagement extends App{
      var library = Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "1234567891"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567892")
  )

  def addBook(book: Book): Unit = {
    library += book
  }

  def removeBookByISBN(isbn: String): Unit = {
    library = library.filterNot(_.isbn == isbn)
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def searchBookByTitle(title: String): Option[Book] = {
    library.find(_.title == title)
  }

  def displayBooksByAuthor(author: String): Unit = {
    library.filter(_.author == author).foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
  }

  displayLibrary()
    addBook(Book("Brave New World", "Aldous Huxley", "1234567893"))
    println("After adding a new book:")
    displayLibrary()
    removeBookByISBN("1234567890")
    println("After removing a book by ISBN:")
    displayLibrary()
    println(s"Is '1984' in the library? ${isBookInLibrary("1234567890")}")
    println("Searching for 'The Great Gatsby':")
    searchBookByTitle("The Great Gatsby").foreach(book => println(s"Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    println("Books by 'Harper Lee':")
    displayBooksByAuthor("Harper Lee")
}