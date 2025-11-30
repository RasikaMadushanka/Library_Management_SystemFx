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
            String SQL = "INSERT INTO book (book_Id, title, author, category, isbn, publisher, publish_year, description, language, copies, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setObject(1, book_Id);
            ps.setObject(2, title);
            ps.setObject(3, author);
            ps.setObject(4, category);
            ps.setObject(5, isbn);
            ps.setObject(6, publisher);
            ps.setString(7, publish_year.trim());
            ps.setObject(8, description);
            ps.setObject(9, language);
            ps.setObject(10, copies);
            ps.setObject(11, status);

            ps.execute();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updatebook(String book_Id, String title, String author, String category, String isbn, String publisher, String publish_year, String description, String language, String copies, String status) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL = "UPDATE book SET title=?, author=?, category=?, isbn=?, publisher=?, publish_year=?, description=?, language=?, copies=?, status=? WHERE book_Id=?";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setObject(1, title);
            ps.setObject(2, author);
            ps.setObject(3, category);
            ps.setObject(4, isbn);
            ps.setObject(5, publisher);
            ps.setObject(6, publish_year);
            ps.setObject(7, description);
            ps.setObject(8, language);
            ps.setObject(9, copies);
            ps.setObject(10, status);
            ps.setObject(11, book_Id);

            ps.executeUpdate();



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



