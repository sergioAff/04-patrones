import constants.Role;
import Model.User;
import Proxy.BookServiceProxy;

import static utils.LibraryUtils.performUserOperations;

public class LibraryApp {
    public static void main(String[] args) {
        BookServiceProxy bookServiceProxy = new BookServiceProxy();

        User guestUser = new User("Sergio", Role.GUEST);
        User memberUser = new User("Adrian", Role.MEMBER);

        System.out.println("\nGuest User Operations:");
        performUserOperations(bookServiceProxy, guestUser, "Java Basics");

        System.out.println("\nMember User Operations:");
        performUserOperations(bookServiceProxy, memberUser, "Design Patterns");
        performUserOperations(bookServiceProxy, memberUser, "Java Basics");
    }
}