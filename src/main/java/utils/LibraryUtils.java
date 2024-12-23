package utils;

import Model.Book;
import Model.User;
import Proxy.BookServiceProxy;

public class LibraryUtils {
  public static void printBookDetails(Book book) {
    if (book != null) {
      System.out.println("Title: " + book.getTitle());
      System.out.println("Author: " + book.getAuthor());
    } else {
      System.out.println("Book not found.");
    }
  }

  public static void performUserOperations(BookServiceProxy bookServiceProxy, User user, String bookTitle) {
    Book book = bookServiceProxy.findBook(bookTitle);
    printBookDetails(book);

    String content = bookServiceProxy.readBookContent(user, bookTitle);
    System.out.println("Content: " + content);
  }
}
