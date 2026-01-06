package Controller.returnbook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.bookReturn_Dto;

import java.net.URL;
import java.util.ResourceBundle;

public class return_book_Form_Controller  implements Initializable {
    ObservableList<bookReturn_Dto>bookReturnDtos = javafx.collections.FXCollections.observableArrayList();
    return_book_Service returnBookService = new return_book_Controller();

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
    private TableView<bookReturn_Dto> returntable;

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
        returnBookService.deleteReturnBook(txtreturn_id.getText());
        loadReturnBooks();

    }

    @FXML
    void btnUpdate_On_Action(ActionEvent event) {
        String return_Id=txtreturn_id.getText();
        String rent_Id=txtrent_id.getText();
        String customer_Id=txtcustomer_id.getText();
        String book_Id=txtbook_id.getText();
        String return_date=txtreturn_date.getText();
        double fine = Double.parseDouble(txtFine.getText());
        double book_price = Double.parseDouble(txtbook_price.getText());
        int late_days = Integer.parseInt(txtlate_days.getText());
        double daily_latefee = Double.parseDouble(txtdailylate_fee.getText());
        double extra_fee = Double.parseDouble(txtextra_fee.getText());
        String status = txtstatus.getText();
        returnBookService.updateReturnBook(return_Id,rent_Id,customer_Id,book_Id,return_date,fine,book_price,late_days,daily_latefee,extra_fee,status);
        loadReturnBooks();

    }

    @FXML
    void btn_add_On_action(ActionEvent event) {
        String return_Id=txtreturn_id.getText();
        String rent_Id=txtrent_id.getText();
        String customer_Id=txtcustomer_id.getText();
        String book_Id=txtbook_id.getText();
        String return_date=txtreturn_date.getText();
        double fine = Double.parseDouble(txtFine.getText());
        double book_price = Double.parseDouble(txtbook_price.getText());
        int late_days = Integer.parseInt(txtlate_days.getText());
        double daily_latefee = Double.parseDouble(txtdailylate_fee.getText());
        double extra_fee = Double.parseDouble(txtextra_fee.getText());
        String status = txtstatus.getText();
        returnBookService.addReturnBook(return_Id,rent_Id,customer_Id,book_Id,return_date,fine,book_price,late_days,daily_latefee,extra_fee,status);
        loadReturnBooks();



    }
    void loadReturnBooks(){
        bookReturnDtos.clear();
        returntable.setItems(returnBookService.getallReturnBook());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colreturn_id.setCellValueFactory(new PropertyValueFactory<>(""));
        colrent_id.setCellValueFactory(new PropertyValueFactory<>(""));
        colcustomer_id.setCellValueFactory(new PropertyValueFactory<>(""));
        colbook_id.setCellValueFactory(new PropertyValueFactory<>(""));
        colreturn_date.setCellValueFactory(new PropertyValueFactory<>(""));
        colfine.setCellValueFactory(new PropertyValueFactory<>(""));
        colbook_price.setCellValueFactory(new PropertyValueFactory<>(""));
        collate_days.setCellValueFactory(new PropertyValueFactory<>(""));
        coldailyfee.setCellValueFactory(new PropertyValueFactory<>(""));
        colextra_fee.setCellValueFactory(new PropertyValueFactory<>(""));
        colstatus.setCellValueFactory(new PropertyValueFactory<>(""));
        loadReturnBooks();
        returntable.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)->{
            bookReturn_Dto bookReturnDto=newvalue;
            if(bookReturnDto != null){
                txtreturn_id.setText(bookReturnDto.getReturnId());
                txtrent_id.setText(bookReturnDto.getRentId());
                txtcustomer_id.setText(bookReturnDto.getCustomerId());
                txtbook_id.setText(bookReturnDto.getBookId());
                txtreturn_date.setText(bookReturnDto.getReturnDate());
                txtFine.setText(String.valueOf(bookReturnDto.getFine()));
                txtbook_price.setText(String.valueOf(bookReturnDto.getBookPrice()));
                txtlate_days.setText(String.valueOf(bookReturnDto.getLateDays()));
                txtdailylate_fee.setText(String.valueOf(bookReturnDto.getDailyLateFee()));
                txtextra_fee.setText(String.valueOf(bookReturnDto.getExtraFee()));
                txtstatus.setText(bookReturnDto.getStatus());
            }
        });



    }
}
