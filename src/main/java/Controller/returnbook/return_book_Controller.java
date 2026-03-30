package Controller.returnbook;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.bookReturn_Dto;
import java.sql.*;

public class return_book_Controller implements return_book_Service {

    @Override
    public void addReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date,
                              double fine, double book_price, int late_days, double extra_fee, double daily_latefee, String status) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            if (connection == null || connection.isClosed()) {
                throw new RuntimeException("Database connection is closed.");
            }

            connection.setAutoCommit(false);

            String sqlReturn = "INSERT INTO book_return (return_Id, rent_Id, customer_Id, book_Id, return_date, fine, bookPrice, late_days, extra_fee, daily_latefee, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmReturn = connection.prepareStatement(sqlReturn);
            pstmReturn.setString(1, return_Id);
            pstmReturn.setString(2, rent_Id);
            pstmReturn.setString(3, customer_Id);
            pstmReturn.setString(4, book_Id);
            pstmReturn.setString(5, return_date);
            pstmReturn.setDouble(6, fine);
            pstmReturn.setDouble(7, book_price);
            pstmReturn.setInt(8, late_days);
            pstmReturn.setDouble(9, extra_fee);
            pstmReturn.setDouble(10, daily_latefee);
            pstmReturn.setString(11, status);
            pstmReturn.executeUpdate();

            String sqlUpdateBook = "UPDATE book SET copies = copies + 1 WHERE book_Id = ?";
            PreparedStatement pstmBook = connection.prepareStatement(sqlUpdateBook);
            pstmBook.setString(1, book_Id);
            pstmBook.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try { if (connection != null && !connection.isClosed()) connection.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            throw new RuntimeException("DB Error: " + e.getMessage());
        } finally {
            try { if (connection != null && !connection.isClosed()) connection.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    @Override
    public ObservableList<bookReturn_Dto> getallReturnBook() {
        ObservableList<bookReturn_Dto> returnList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM book_return";

        // REMOVED Connection from try-with-resources to keep it open
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                returnList.add(new bookReturn_Dto(
                        resultSet.getString("return_Id"), resultSet.getString("rent_Id"),
                        resultSet.getString("customer_Id"), resultSet.getString("book_Id"),
                        resultSet.getString("return_date"), resultSet.getDouble("fine"),
                        resultSet.getDouble("bookPrice"), resultSet.getInt("late_days"),
                        resultSet.getDouble("daily_latefee"), resultSet.getDouble("extra_fee"),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
        return returnList;
    }

    @Override
    public void deleteReturnBook(String return_id) {
        String sql = "DELETE FROM book_return WHERE return_Id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, return_id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void updateReturnBook(String return_Id, String rent_Id, String customer_Id, String book_Id, String return_date,
                                 double fine, double book_price, int late_days, double extra_fee, double daily_latefee, String status) {
        String sql = "UPDATE book_return SET rent_Id=?, customer_Id=?, book_Id=?, return_date=?, fine=?, bookPrice=?, late_days=?, extra_fee=?, daily_latefee=?, status=? WHERE return_Id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, rent_Id); pstm.setString(2, customer_Id);
            pstm.setString(3, book_Id); pstm.setString(4, return_date);
            pstm.setDouble(5, fine); pstm.setDouble(6, book_price);
            pstm.setInt(7, late_days); pstm.setDouble(8, extra_fee);
            pstm.setDouble(9, daily_latefee); pstm.setString(10, status);
            pstm.setString(11, return_Id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}