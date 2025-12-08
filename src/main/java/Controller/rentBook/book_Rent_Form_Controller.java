package Controller.rentBook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class book_Rent_Form_Controller {

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
    private TableView<?> tblrentbook;

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

    @FXML
    void btn_Add_On_action(ActionEvent event) {

    }

    @FXML
    void btn_Delete_On_action(ActionEvent event) {

    }

    @FXML
    void btn_Update_On_action(ActionEvent event) {

    }

}
