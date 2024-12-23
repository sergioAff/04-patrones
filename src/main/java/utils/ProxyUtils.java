package utils;

import Model.Book;
import Model.User;

import java.util.Map;

public class ProxyUtils {
  public static boolean isBookInCache(Map<String, Book> cache, String title) {
    return cache.containsKey(title);
  }

  public static Book fetchBookFromCache(Map<String, Book> cache,String title) {
    System.out.println("Fetching book from cache: " + title);
    return cache.get(title);
  }

  public static void logAccess(Map<String, String> accessLog, User user, String title, String action) {
    String logEntry = "User: " + user.getName() + " Role: " + user.getRole() + " Action: " + action + " Book: " + title;
    accessLog.put(user.getName() + "-" + title, logEntry);
    System.out.println(logEntry);
  }
}
