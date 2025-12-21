package Controller.rentBook;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.bookRent_Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class book_Rent_Controller implements book_Rent_Service {


    @Override
    public void addbookRent(String rent_Id, String customer_Id, String book_Id, String rent_date, String due_date, String return_date, double price, double fine, String status) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "InsERT INTO book_rent (rent_Id, customer_Id, book_Id, rent_date, due_date, return_date, price, fine, status) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, rent_Id);
            preparedStatement.setObject(2, customer_Id);
            preparedStatement.setObject(3, book_Id);
            preparedStatement.setObject(4, rent_date);
            preparedStatement.setObject(5, due_date);
            preparedStatement.setObject(6, return_date);
            preparedStatement.setObject(7, price);
            preparedStatement.setObject(8, fine);
            preparedStatement.setObject(9, status);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatebookRent(String rent_Id, String customer_Id, String book_Id, String rent_date, String due_date, String return_date, double price, double fine, String status) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE book_rent SET customer_Id = ?, book_Id = ?, rent_date = ?, due_date = ?, return_date = ?, price = ?, fine = ?, status = ? WHERE rent_Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, customer_Id);
            preparedStatement.setObject(2, book_Id);
            preparedStatement.setObject(3, rent_date);
            preparedStatement.setObject(4, due_date);
            preparedStatement.setObject(5, return_date);
            preparedStatement.setObject(6, price);
            preparedStatement.setObject(7, fine);
            preparedStatement.setObject(8, status);
            preparedStatement.setObject(9, rent_Id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletebookRent(String rent_Id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "DELETE FROM book_rent WHERE rent_Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, rent_Id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<bookRent_Dto> getallbookRent() {
        ObservableList<bookRent_Dto> boolrendetails = javafx.collections.FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM book_rent";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                boolrendetails.add(new bookRent_Dto(
                        resultSet.getString("rent_Id"),
                        resultSet.getString("customer_Id"),
                        resultSet.getString("book_Id"),
                        resultSet.getString("rent_date"),
                        resultSet.getString("due_date"),
                        resultSet.getString("return_date"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("fine"),
                        resultSet.getString("status")
                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return boolrendetails;
    }



}
