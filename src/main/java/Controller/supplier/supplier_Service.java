package Controller.supplier;

import javafx.collections.ObservableList;
import model.dto.supplier_Dto;

public interface supplier_Service {
    void addsupplier(String supplier_Id,String name,String phone,String email,String address, String company,String date);
    void updatesupplier(String supplier_Id,String name,String phone,String email,String address, String company,String date);
    void deletesupplier(String supplier_Id);
    ObservableList<supplier_Dto> getallsupplier();
}
