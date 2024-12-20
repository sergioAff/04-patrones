package Interface;


import Model.Book;

public interface IBookService {
    Book findBook(String title);
}