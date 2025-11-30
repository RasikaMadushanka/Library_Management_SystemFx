package Controller.Customer;

import javafx.collections.ObservableList;
import model.dto.customer_Dto;

public interface customer_Service {
    void addCustomer(String customer_Id,String name,String phone,String email,String address, String date);
    void updateCustomer(String customer_Id,String name,String phone,String email,String address, String date);
    void deleteCustomer(String customer_Id);
    ObservableList<customer_Dto>getallCustomer();
}
