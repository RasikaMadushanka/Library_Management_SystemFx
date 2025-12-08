package Controller.supplier;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.supplier_Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class supplier_Controller implements supplier_Service {
    @Override
    public void addsupplier(String supplier_Id, String name, String phone, String email, String address, String company, String date) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "INSERT INTO supplier VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, supplier_Id);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, phone);
            preparedStatement.setObject(4, email);
            preparedStatement.setObject(5, address);
            preparedStatement.setObject(6, company);
            preparedStatement.setObject(7, date);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatesupplier(String supplier_Id, String name, String phone, String email, String address, String company, String date) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE supplier SET name=?, phone=?, email=?, address=?, company=?, joined_date=? WHERE supplier_Id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, name);
            preparedStatement.setObject(2, phone);
            preparedStatement.setObject(3, email);
            preparedStatement.setObject(4, address);
            preparedStatement.setObject(5, company);
            preparedStatement.setObject(6, date);
            preparedStatement.setObject(7, supplier_Id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deletesupplier(String supplier_Id) {
        try {
            Connection connection =DBConnection.getInstance().getConnection();
            String SQL = "DELETE FROM supplier WHERE supplier_Id=?";
            PreparedStatement pstm = connection.prepareStatement(SQL);
            pstm.setString(1, supplier_Id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override

    public ObservableList<supplier_Dto> getallsupplier() {
        ObservableList<supplier_Dto> allsupplierDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM supplier";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                allsupplierDetails.add(new supplier_Dto(
                        resultSet.getString("supplierId"),
                        resultSet.getString("supplierName"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getString("company"),
                        resultSet.getString("date")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allsupplierDetails;
    }
}


