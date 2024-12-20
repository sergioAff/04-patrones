package Services;

import Data.BookData;
import Interface.IBookService;
import Model.Book;

import java.util.Map;

public class RealBookService implements IBookService {
    private Map<String, Book> bookDatabase;

    public RealBookService() {
        this.bookDatabase = BookData.initializeData();
    }

    @Override
    public Book findBook(String title) {
        return bookDatabase.get(title);
    }
    public String readBookContent(String title) {
        Book book = bookDatabase.get(title);
        return (book != null) ? book.getContent() : null;
    }
}