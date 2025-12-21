package Controller.Customer;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.customer_Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customer_Controller implements customer_Service{
    @Override
    public void addCustomer(String customer_Id, String name, String phone, String email, String address, String date) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "INSERT INTO customer VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,customer_Id);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,phone);
            preparedStatement.setObject(4,email);
            preparedStatement.setObject(5,address);
            preparedStatement.setObject(6,date);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateCustomer(String customer_Id, String name, String phone, String email, String address, String date) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE customer SET full_name=?, phone=?, email=?, address=?, joined_date=? WHERE customer_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,name);
            preparedStatement.setObject(2,phone);
            preparedStatement.setObject(3,email);
            preparedStatement.setObject(4,address);
            preparedStatement.setObject(5,date);
            preparedStatement.setObject(6,customer_Id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCustomer(String customer_Id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM customer WHERE customer_Id=?");
            pstm.setString(1, customer_Id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<customer_Dto> getallCustomer() {
        ObservableList<customer_Dto> customerDetail = javafx.collections.FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM customer";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
          while (resultSet.next()){
              customerDetail.add(new customer_Dto(
                      resultSet.getString("customer_id"),
                      resultSet.getString("full_name"),
                      resultSet.getString("phone"),
                      resultSet.getString("email"),
                      resultSet.getString("address"),
                      resultSet.getString("joined_date")
              ));


          }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDetail;

    }
}
