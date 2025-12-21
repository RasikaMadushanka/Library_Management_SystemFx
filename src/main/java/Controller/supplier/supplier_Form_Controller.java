package Controller.supplier;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.supplier_Dto;

import java.net.URL;
import java.util.ResourceBundle;

public class supplier_Form_Controller implements Initializable {
    ObservableList<supplier_Dto> supplier_dtos = javafx.collections.FXCollections.observableArrayList();
    supplier_Service supplier_service = new supplier_Controller();

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colcompany;

    @FXML
    private TableColumn<?, ?> colphone;
    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableView<supplier_Dto> tblsupplier;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtcompany;

    @FXML
    private TextField txtphone;
    @FXML
    private TextField txtdate;

    @FXML
    void btn_Delete_On_Action(ActionEvent event) {
        supplier_service.deletesupplier(txtId.getText());
        loadsupplier();
        clear();


    }

    @FXML
    void btn_Update_On_Action(ActionEvent event) {
        String Id = txtId.getText();
        String name= txtname.getText();
        String phone =txtphone.getText();
        String email = txtemail.getText();
        String address = txtaddress.getText();
        String company = txtcompany.getText();
        String Date= txtdate.getText();
        supplier_service.addsupplier(Id,name,phone,email,address,company,Date);
        loadsupplier();
        clear();


    }

    @FXML
    void btn_add_On_Action(ActionEvent event) {
        String Id = txtId.getText();
        String name= txtname.getText();
        String phone =txtphone.getText();
        String email = txtemail.getText();
        String address = txtaddress.getText();
        String company = txtcompany.getText();
        String Date= txtdate.getText();
        supplier_service.addsupplier(Id,name,phone,email,address,company,Date);
        clear();
        loadsupplier();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colid.setCellValueFactory(new PropertyValueFactory<>(""));
        colname.setCellValueFactory(new PropertyValueFactory<>(""));
        colphone.setCellValueFactory(new PropertyValueFactory<>(""));
        colemail.setCellValueFactory(new PropertyValueFactory<>(""));
        coladdress.setCellValueFactory(new PropertyValueFactory<>(""));
        colcompany.setCellValueFactory(new PropertyValueFactory<>(""));
        coldate.setCellValueFactory(new PropertyValueFactory<>(""));
        loadsupplier();
        tblsupplier.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)-> {
            supplier_Dto supplierDto= newvalue;
            if (supplierDto != null) {
                txtId.setText(supplierDto.getSupplierId());
                txtname.setText(supplierDto.getSupplierName());
                txtphone.setText(supplierDto.getPhone());
                txtemail.setText(supplierDto.getEmail());
                txtaddress.setText(supplierDto.getAddress());
                txtcompany.setText(supplierDto.getCompany());
                txtdate.setText(supplierDto.getDate());


            }

        });
        }
    void loadsupplier (){
        supplier_dtos.clear();
        tblsupplier.setItems(supplier_service.getallsupplier());
    }
    void  clear(){
        txtId.clear();
        txtname.clear();
        txtphone.clear();
        txtemail.clear();
        txtaddress.clear();
        txtcompany.clear();
        txtdate.clear();
    }
}
