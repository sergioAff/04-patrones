package Data;

import Model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookData {
    public static Map<String, Book> initializeData() {
        Map<String, Book> bookDatabase = new HashMap<>();
        bookDatabase.put("Java Basics", new Book("Java Basics", "John Doe", "Content of Java Basics"));
        bookDatabase.put("Design Patterns", new Book("Design Patterns", "Jane Smith", "Content of Design Patterns"));
        bookDatabase.put("Advanced Java", new Book("Advanced Java", "James Brown", "Content of Advanced Java"));
        bookDatabase.put("Algorithms", new Book("Algorithms", "Robert Martin", "Content of Algorithms"));
        bookDatabase.put("SQL", new Book("SQL", "Susan Anderson", "Content of SQL"));
        return bookDatabase;
    }
}
