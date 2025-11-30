package Controller.book;

import javafx.collections.ObservableList;
import model.dto.Book;

public interface book_Service {
  void addbook(String book_Id,String title,String author,String category,String isbn,String publisher,String publish_year,String description,String language,int copies,String status);
  void updatebook(String book_Id,String title,String author,String category,String isbn,String publisher,String publish_year,String description,String language,String copies,String status);
  void deletebook(String book_Id);
    ObservableList<Book>getAllbook();
}
