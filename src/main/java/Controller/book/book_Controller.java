package Controller.book;


import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class book_Controller implements book_Service {

    @Override
    public void addbook(String book_Id, String title, String author, String category, String isbn, String publisher, String publish_year, String description, String language, int copies, String status) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "INSERT INTO book VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, book_Id);
            preparedStatement.setObject(2, title);
            preparedStatement.setObject(3, author);
            preparedStatement.setObject(4, category);
            preparedStatement.setObject(5, isbn);
            preparedStatement.setObject(6, publisher);
            preparedStatement.setObject(7, publish_year);
            preparedStatement.setObject(8, description);
            preparedStatement.setObject(9, language);
            preparedStatement.setObject(10, copies);
            preparedStatement.setObject(11, status);
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updatebook(String book_Id, String title, String author, String category, String isbn, String publisher, String publish_year, String description, String language, int copies, String status) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL = "UPDATE book SET title=?,author=?,category=?,isbn=?,publisher=?,publish_year=?,description=?,language=?,copies=?,status=? WHERE book_Id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletebook(String book_Id) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM book WHERE book_Id=?");
            pstm.setString(1, book_Id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<Book> getAllbook() {
        ObservableList<Book>bookDetails=javafx.collections.FXCollections.observableArrayList();
        try {
            Connection  connection = DBConnection.getInstance().getConnection();
            String SQL="SELECT * FROM book";
            PreparedStatement preparedStatement=connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                bookDetails.add(new Book(
                                resultSet.getString("book_Id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("category"),
                        resultSet.getString("isbn"),
                        resultSet.getString("publisher"),
                        resultSet.getString("publish_year"),
                        resultSet.getString("description"),
                        resultSet.getString("language"),
                        resultSet.getInt("copies"),
                        resultSet.getString("status")

                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bookDetails;
    }
    }



