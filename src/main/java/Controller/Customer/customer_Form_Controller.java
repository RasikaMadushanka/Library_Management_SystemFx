package Controller.Customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Book;
import model.dto.customer_Dto;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class customer_Form_Controller implements Initializable {
    ObservableList<customer_Dto>customerDtos= FXCollections.observableArrayList();
    customer_Service customer_service = new customer_Controller();


    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colemail;
    @FXML
    private TableColumn<?, ?> colphone;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableView<customer_Dto> tblcustomer;

    @FXML
    private TextField txtaddresss;

    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;
    @FXML
    private TextField txtphone;



    @FXML
    void btnadd_On_Action(ActionEvent event) {
        String Id=txtid.getText();
        String Name=txtname.getText();
        String Phone=txtphone.getText();
        String email=txtemail.getText();
        String address=txtaddresss.getText();
        String date =txtdate.getText();

        customer_service.addCustomer(Id,Name,Phone,email,address,date);
        loadcustomer();
        clear();


    }

    @FXML
    void btndelete_On_Action(ActionEvent event) {

            customer_service.deleteCustomer(txtid.getText());
            loadcustomer();
            clear();

    }

    @FXML
    void btnupdate_On_Action(ActionEvent event) {
        String Id=txtid.getText();
        String Name=txtname.getText();
        String Phone=txtphone.getText();
        String email=txtemail.getText();
        String address=txtaddresss.getText();
        String date =txtdate.getText();

        customer_service.updateCustomer(Id,Name,Phone,email,address,date);
        loadcustomer();
        clear();

    }
    public void loadcustomer(){

        customerDtos.clear();
        tblcustomer.setItems(customer_service.getallCustomer());



    }
    void clear(){
        txtid.clear();
        txtaddresss.clear();
        txtdate.clear();
        txtname.clear();
        txtemail.clear();
        txtphone.clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colid.setCellValueFactory(new PropertyValueFactory<>(""));
        tblcustomer.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)->{
            customer_Dto customerDto=newvalue;
            if (customerDto != null) {
                txtid.setText(customerDto.getCustomer_id());
                


            }

        });

    }
}
