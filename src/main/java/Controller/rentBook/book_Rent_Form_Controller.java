package Controller.rentBook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.dto.bookRent_Dto;


public class book_Rent_Form_Controller {
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
        String customer_Id




    }

    @FXML
    void btn_Delete_On_action(ActionEvent event) {

    }

    @FXML
    void btn_Update_On_action(ActionEvent event) {

    }

}
