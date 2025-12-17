package Controller.returnbook;

import javafx.collections.ObservableList;
import model.dto.bookReturn_Dto;

public class return_book_Controller implements return_book_Service{
    @Override
    public void addReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date, double fine, double book_price, int late_days, double extra_fee, double daily_latefee, String status) {

    }

    @Override
    public void updateReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date, double fine, double book_price, int late_days, double extra_fee, double daily_latefee, String status) {

    }

    @Override
    public void deleteReturnBook(String return_id) {

    }

    @Override
    public ObservableList<bookReturn_Dto> getallReturnBook() {
        return null;
    }
}
