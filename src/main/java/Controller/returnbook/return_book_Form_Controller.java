package Controller.returnbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class return_book_Form_Controller  implements Initializable {

    @FXML
    private TableColumn<?, ?> colbook_id;

    @FXML
    private TableColumn<?, ?> colbook_price;

    @FXML
    private TableColumn<?, ?> colcustomer_id;

    @FXML
    private TableColumn<?, ?> coldailyfee;

    @FXML
    private TableColumn<?, ?> colextra_fee;

    @FXML
    private TableColumn<?, ?> colfine;

    @FXML
    private TableColumn<?, ?> collate_days;

    @FXML
    private TableColumn<?, ?> colrent_id;

    @FXML
    private TableColumn<?, ?> colreturn_date;

    @FXML
    private TableColumn<?, ?> colreturn_id;

    @FXML
    private TableColumn<?, ?> colstatus;

    @FXML
    private TableView<?> returntable;

    @FXML
    private TextField txtFine;

    @FXML
    private TextField txtbook_id;

    @FXML
    private TextField txtbook_price;

    @FXML
    private TextField txtcustomer_id;

    @FXML
    private TextField txtdailylate_fee;

    @FXML
    private TextField txtextra_fee;

    @FXML
    private TextField txtlate_days;

    @FXML
    private TextField txtrent_id;

    @FXML
    private TextField txtreturn_date;

    @FXML
    private TextField txtreturn_id;

    @FXML
    private TextField txtstatus;

    @FXML
    void btnDelete_On_Action(ActionEvent event) {

    }

    @FXML
    void btnUpdate_On_Action(ActionEvent event) {

    }

    @FXML
    void btn_add_On_action(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}
