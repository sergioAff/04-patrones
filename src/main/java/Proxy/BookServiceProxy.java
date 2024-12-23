package Proxy;

import Interface.IBookService;
import Model.Book;
import constants.Role;
import Model.User;
import Services.RealBookService;

import java.util.HashMap;
import java.util.Map;

import static utils.ProxyUtils.fetchBookFromCache;
import static utils.ProxyUtils.isBookInCache;
import static utils.ProxyUtils.logAccess;

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
        if (isBookInCache(cache,title)) {
            return fetchBookFromCache(cache,title);
        }
        return fetchBookFromServiceAndCache(title);
    }

    private Book fetchBookFromServiceAndCache(String title) {
        System.out.println("Fetching book from real service: " + title);
        Book book = realBookService.findBook(title);
        if (book != null) {
            cache.put(title, book);
        }
        return book;
    }

    public String readBookContent(User user, String title) {
        logAccess(accessLog,user, title, "read");
        if (user.getRole() == Role.MEMBER) {
            return realBookService.readBookContent(title);
        } else {
            return "Access Denied: Guests are not allowed to read full content.";
        }
    }
}