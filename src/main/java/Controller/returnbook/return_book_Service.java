package Controller.returnbook;

import javafx.collections.ObservableList;
import model.dto.bookReturn_Dto;

public interface return_book_Service {
    void addReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date, double fine,double book_price,int late_days,double extra_fee,double daily_latefee,String status);
    void updateReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date, double fine,double book_price,int late_days,double extra_fee,double daily_latefee,String status);
    void deleteReturnBook(String return_id);
    ObservableList<bookReturn_Dto> getallReturnBook();

}
