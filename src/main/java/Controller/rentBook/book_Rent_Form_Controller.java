package Controller.rentBook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.bookRent_Dto;

import java.net.URL;
import java.util.ResourceBundle;


public class book_Rent_Form_Controller implements Initializable {
    ObservableList<bookRent_Dto>bookRentDtos = javafx.collections.FXCollections.observableArrayList();
    book_Rent_Service bookRentService = new book_Rent_Controller();


    @FXML
    private TableColumn<?, ?> colbook_id;

    @FXML
    private TableColumn<?, ?> colbook_price;

    @FXML
    private TableColumn<?, ?> colcustomer_id;

    @FXML
    private TableColumn<?, ?> coldue_date;

    @FXML
    private TableColumn<?, ?> colfine;

    @FXML
    private TableColumn<?, ?> colrent_date;

    @FXML
    private TableColumn<?, ?> colrent_id;

    @FXML
    private TableColumn<?, ?> colreturn_date;

    @FXML
    private TableColumn<?, ?> colstatus;

    @FXML
    private TableView<bookRent_Dto> tblrentbook;

    @FXML
    private TextField txtbook_id;

    @FXML
    private TextField txtbook_price;

    @FXML
    private TextField txtcustomer_id;

    @FXML
    private TextField txtdue_date;

    @FXML
    private TextField txtfine;

    @FXML
    private TextField txtrent_date;

    @FXML
    private TextField textreturndate;

    @FXML
    private TextField txtrent_id;

    @FXML
    private TextField txtstatus;

    void loadrentbook(){
        bookRentDtos.clear();
        tblrentbook.setItems(bookRentService.getallbookRent());
    }

    @FXML
    void btn_Add_On_action(ActionEvent event) {
        String id = txtrent_id.getText();
        String customer_Id = txtcustomer_id.getText();
        String book_id=txtbook_id.getText();
        String rent_date = txtrent_date.getText();
        String due_date = txtdue_date.getText();
        String return_date = textreturndate.getText();
        double price = Double.parseDouble(txtbook_price.getText());
        double fine = Double.parseDouble(txtfine.getText());
        String status = txtstatus.getText();
        bookRentService.addbookRent(id,customer_Id,book_id,rent_date,due_date,return_date,price,fine,status);
        loadrentbook();
        clear();




    }

    @FXML
    void btn_Delete_On_action(ActionEvent event) {

    }

    @FXML
    void btn_Update_On_action(ActionEvent event) {
        String id = txtrent_id.getText();
        String customer_Id = txtcustomer_id.getText();
        String book_id=txtbook_id.getText();
        String rent_date = txtrent_date.getText();
        String due_date = txtdue_date.getText();
        String return_date = textreturndate.getText();
        double price = Double.parseDouble(txtbook_price.getText());
        double fine = Double.parseDouble(txtfine.getText());
        String status = txtstatus.getText();
        bookRentService.updatebookRent(id,customer_Id,book_id,rent_date,due_date,return_date,price,fine,status);
        loadrentbook();
        clear();

    }
    void clear(){
        txtrent_id.clear();;
        txtcustomer_id.clear();
        txtbook_id.clear();
        txtrent_date.clear();
        txtdue_date.clear();
        textreturndate.clear();
        txtbook_price.clear();
        txtfine.clear();
        txtstatus.clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colrent_id.setCellValueFactory(new PropertyValueFactory<>("rentId"));
        colcustomer_id.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colbook_id.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colrent_date.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        coldue_date.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colreturn_date.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colbook_price.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        colfine.setCellValueFactory(new PropertyValueFactory<>("fine"));
        colstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tblrentbook.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)->{
            bookRent_Dto bookRentDto = newvalue;
           if(bookRentDto != null ){
                txtrent_id.setText(bookRentDto.getRentId());
                txtcustomer_id.setText(bookRentDto.getCustomerId());
                txtbook_id.setText(bookRentDto.getBookId());
                txtrent_date.setText(bookRentDto.getRentDate());
                txtdue_date.setText(bookRentDto.getDueDate());
                textreturndate.setText(bookRentDto.getReturnDate());
                txtbook_price.setText(String.valueOf(bookRentDto.getBookPrice()));
                txtfine.setText(String.valueOf(bookRentDto.getFine()));
                txtstatus.setText(bookRentDto.getStatus());

           }
        });

    }
}
