package Controller.returnbook;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.bookReturn_Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class return_book_Controller implements return_book_Service{
    @Override
    public void addReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date, double fine, double book_price, int late_days, double extra_fee, double daily_latefee, String status) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "INSERT INTO book_return VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,return_Id);
            preparedStatement.setObject(2,rent_Id);
            preparedStatement.setObject(3,customer_Id);
            preparedStatement.setObject(4,book_Id);
            preparedStatement.setObject(5,return_date);
            preparedStatement.setObject(6,fine);
            preparedStatement.setObject(7,book_price);
            preparedStatement.setObject(8,late_days);
            preparedStatement.setObject(9,extra_fee);
            preparedStatement.setObject(10,daily_latefee);
            preparedStatement.setObject(11,status);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date, double fine, double book_price, int late_days, double extra_fee, double daily_latefee, String status) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE book_return SET rent_Id=?, customer_Id=?, book_Id=?, return_date=?, fine=?, book_price=?, late_days=?, extra_fee=?, daily_latefee=?, status=? WHERE return_Id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,rent_Id);
            preparedStatement.setObject(2,customer_Id);
            preparedStatement.setObject(3,book_Id);
            preparedStatement.setObject(4,return_date);
            preparedStatement.setObject(5,fine);
            preparedStatement.setObject(6,book_price);
            preparedStatement.setObject(7,late_days);
            preparedStatement.setObject(8,extra_fee);
            preparedStatement.setObject(9,daily_latefee);
            preparedStatement.setObject(10,status);
            preparedStatement.setObject(11,return_date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteReturnBook(String return_id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "DELETE FROM book_return WHERE return_Id=?";
            PreparedStatement pstm = connection.prepareStatement(SQL);
            pstm.setString(1, return_id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<bookReturn_Dto> getallReturnBook() {
        ObservableList<bookReturn_Dto>  returnBookDetails = javafx.collections.FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM book_return";;
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                returnBookDetails.add(new bookReturn_Dto(
                        resultSet.getString("return_Id"),
                        resultSet.getString("rent_Id"),
                        resultSet.getString("customer_Id"),
                        resultSet.getString("book_Id"),
                        resultSet.getString("return_date"),
                        resultSet.getDouble("fine"),
                        resultSet.getDouble("book_price"),
                        resultSet.getInt("late_days"),
                        resultSet.getDouble("extra_fee"),
                        resultSet.getDouble("daily_latefee"),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return returnBookDetails;
    }
}
