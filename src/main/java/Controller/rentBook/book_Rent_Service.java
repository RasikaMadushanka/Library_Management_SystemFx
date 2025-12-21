package Controller.rentBook;

import javafx.collections.ObservableList;
import model.dto.bookRent_Dto;

public interface book_Rent_Service {
    void addbookRent(String rent_Id, String customer_Id,String book_Id, String rent_date,String due_date, String return_date, double price,double fine,String status);
    void updatebookRent(String rent_Id, String customer_Id,String book_Id, String rent_date,String due_date, String return_date, double price,double fine,String status);
    void deletebookRent(String rent_Id);
    ObservableList<bookRent_Dto> getallbookRent();
}
