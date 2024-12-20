import Model.Book;
import Model.Role;
import Model.User;
import Proxy.BookServiceProxy;

public class LibraryApp {
    public static void main(String[] args) {
        BookServiceProxy bookServiceProxy = new BookServiceProxy();

        User guestUser = new User("Sergio", Role.GUEST);
        User memberUser = new User("Adrian", Role.MEMBER);

        System.out.println("\nGuest User Operations:");
        Book book1 = bookServiceProxy.findBook("Java Basics");
        printBookDetails(book1);

        String content1 = bookServiceProxy.readBookContent(guestUser, "Java Basics");
        System.out.println("Content: " + content1);

        System.out.println("\nMember User Operations:");
        Book book2 = bookServiceProxy.findBook("Design Patterns");
        printBookDetails(book2);

        String content2 = bookServiceProxy.readBookContent(memberUser, "Design Patterns");
        System.out.println("Content: " + content2);

        Book book3 = bookServiceProxy.findBook("Java Basics");
        printBookDetails(book3);

        String content3 = bookServiceProxy.readBookContent(memberUser, "Java Basics");
        System.out.println("Content: " + content3);
    }

    private static void printBookDetails(Book book) {
        if (book != null) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }
}