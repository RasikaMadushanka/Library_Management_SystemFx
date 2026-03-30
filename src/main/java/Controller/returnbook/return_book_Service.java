package Controller.returnbook;

import javafx.collections.ObservableList;
import model.dto.bookReturn_Dto;

/**
 * Service Interface for Book Return operations.
 * Defines the contract for business logic and database interactions.
 */
public interface return_book_Service {

    /**
     * Records a new book return and updates inventory levels.
     */
    void addReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date,
                       double fine, double book_price, int late_days, double extra_fee, double daily_latefee, String status);

    /**
     * Updates an existing return record.
     */
    void updateReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date,
                          double fine, double book_price, int late_days, double extra_fee, double daily_latefee, String status);

    /**
     * Deletes a return record from the system.
     */
    void deleteReturnBook(String return_id);

    /**
     * Retrieves all return records for the TableView.
     * @return ObservableList of bookReturn_Dto objects.
     */
    ObservableList<bookReturn_Dto> getallReturnBook();
}