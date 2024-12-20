package Proxy;

import Interface.IBookService;
import Model.Book;
import Model.Role;
import Model.User;
import Services.RealBookService;

import java.util.HashMap;
import java.util.Map;

public class BookServiceProxy implements IBookService {
    private RealBookService realBookService;
    private Map<String, Book> cache;
    private Map<String, String> accessLog;

    public BookServiceProxy() {
        this.realBookService = new RealBookService();
        this.cache = new HashMap<>();
        this.accessLog = new HashMap<>();
    }

    @Override
    public Book findBook(String title) {
        if (cache.containsKey(title)) {
            System.out.println("Fetching book from cache: " + title);
            return cache.get(title);
        }
        System.out.println("Fetching book from real service: " + title);
        Book book = realBookService.findBook(title);
        if (book != null) {
            cache.put(title, book);
        }
        return book;
    }
    public String readBookContent(User user, String title) {
        logAccess(user, title, "read");
        if (user.getRole() == Role.MEMBER) {
            return realBookService.readBookContent(title);
        } else {
            return "Access Denied: Guests are not allowed to read full content.";
        }
    }

    private void logAccess(User user, String title, String action) {
        String logEntry = "User: " + user.getName() + " Role: " + user.getRole() + " Action: " + action + " Book: " + title;
        accessLog.put(user.getName() + "-" + title, logEntry);
        System.out.println(logEntry);
    }

}