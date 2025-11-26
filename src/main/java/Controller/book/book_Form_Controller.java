package Controller.book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Book;
import java.net.URL;
import java.util.ResourceBundle;

public class book_Form_Controller implements Initializable {
    ObservableList<java.awt.print.Book> bookDtos= FXCollections.observableArrayList();
    book_Service bookService=new book_Controller();

    @FXML
    private TableColumn<?, ?> colauthor;

    @FXML
    private TableColumn<?, ?> colbook_id;

    @FXML
    private TableColumn<?, ?> colcategory;

    @FXML
    private TableColumn<?, ?> colcopies;

    @FXML
    private TableColumn<?, ?> coldescription;

    @FXML
    private TableColumn<?, ?> colisbn;

    @FXML
    private TableColumn<?, ?> collanguages;

    @FXML
    private TableColumn<?, ?> colpublisher;

    @FXML
    private TableColumn<?, ?> colpublisher_year;

    @FXML
    private TableColumn<?, ?> colstatus;

    @FXML
    private TableColumn<?, ?> coltitle;

    @FXML
    private TableView<Book> tblbook;

    @FXML
    private TextField txtauthor;

    @FXML
    private TextField txtcategory;

    @FXML
    private TextField txtcopies;

    @FXML
    private TextField txtdescription;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtisbn;

    @FXML
    private TextField txtlanguages;

    @FXML
    private TextField txtpublish_year;

    @FXML
    private TextField txtpublisher;

    @FXML
    private TextField txtstatus;

    @FXML
    private TextField txttitle;

    @FXML
    void btnAddbook(ActionEvent event) {


    }

    @FXML
    void btnDeletebook(ActionEvent event) {
        bookService.deletebook(txtid.getText());
        loadEmployee();

    }

    @FXML
    void btnUpdatebook(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colbook_id.setCellValueFactory(new PropertyValueFactory<>("book_Id"));
        coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colauthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colisbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colpublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        colpublisher_year.setCellValueFactory(new PropertyValueFactory<>("publish_year"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        collanguages.setCellValueFactory(new PropertyValueFactory<>("language"));
        colcopies.setCellValueFactory(new PropertyValueFactory<>("copies"));
        colstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        loadEmployee();
        tblbook.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)->{
            Book bookDto=newvalue;
            if (bookDto != null){
                txtid.setText(bookDto.getBook_Id());
                txttitle.setText(bookDto.getTitle());
                txtauthor.setText(bookDto.getAuthor());
                txtcategory.setText(bookDto.getCategory());
                txtisbn.setText(bookDto.getIsbn());
                txtpublisher.setText(bookDto.getPublisher());
                txtpublish_year.setText(bookDto.getPublish_year());
                txtdescription.setText(bookDto.getDescription());
                txtlanguages.setText(bookDto.getLanguage());
                txtcopies.setText(String.valueOf(bookDto.getCopies()));
                txtstatus.setText(bookDto.getStatus());
            }


        });
    }

    private void loadEmployee(){
        bookDtos.clear();;
        tblbook.setItems(bookService.getAllbook());
    }
}


