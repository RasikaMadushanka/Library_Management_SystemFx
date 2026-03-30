package Controller.returnbook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.bookReturn_Dto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class return_book_Form_Controller implements Initializable {

    private return_book_Service returnBookService = new return_book_Controller();

    @FXML private TableView<bookReturn_Dto> returntable;
    @FXML private TableColumn<?, ?> colreturn_id, colrent_id, colcustomer_id, colbook_id, colreturn_date, colfine, colbook_price, collate_days, coldailyfee, colextra_fee, colstatus;
    @FXML private TextField txtreturn_id, txtrent_id, txtcustomer_id, txtbook_id, txtreturn_date, txtFine, txtbook_price, txtlate_days, txtdailylate_fee, txtextra_fee, txtstatus;

    @FXML
    void btn_add_On_action(ActionEvent event) {
        try {
            returnBookService.addReturnBook(
                    txtreturn_id.getText(),
                    txtrent_id.getText(),
                    txtcustomer_id.getText(),
                    txtbook_id.getText(),
                    txtreturn_date.getText(),
                    safeParse(txtFine.getText()),
                    safeParse(txtbook_price.getText()),
                    (int) safeParse(txtlate_days.getText()),
                    safeParse(txtextra_fee.getText()),
                    safeParse(txtdailylate_fee.getText()),
                    txtstatus.getText()
            );
            loadReturnBooks();
            clearFields();
            new Alert(Alert.AlertType.INFORMATION, "Book Return Processed Successfully!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdate_On_Action(ActionEvent event) {
        try {
            returnBookService.updateReturnBook(
                    txtreturn_id.getText(),
                    txtrent_id.getText(),
                    txtcustomer_id.getText(),
                    txtbook_id.getText(),
                    txtreturn_date.getText(),
                    safeParse(txtFine.getText()),
                    safeParse(txtbook_price.getText()),
                    (int) safeParse(txtlate_days.getText()),
                    safeParse(txtdailylate_fee.getText()),
                    safeParse(txtextra_fee.getText()),
                    txtstatus.getText()
            );
            loadReturnBooks();
            new Alert(Alert.AlertType.INFORMATION, "Record Updated!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Update Failed: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnDelete_On_Action(ActionEvent event) {
        if (!txtreturn_id.getText().isEmpty()) {
            returnBookService.deleteReturnBook(txtreturn_id.getText());
            loadReturnBooks();
            clearFields();
        }
    }

    private double safeParse(String value) {
        if (value == null || value.trim().isEmpty()) return 0.0;
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private void clearFields() {
        txtreturn_id.clear();
        txtrent_id.clear();
        txtcustomer_id.clear();
        txtbook_id.clear();
        txtFine.clear();
        txtbook_price.clear();
        txtlate_days.clear();
        txtdailylate_fee.clear();
        txtextra_fee.clear();
        txtstatus.clear();
        txtreturn_date.setText(LocalDate.now().toString());
    }

    void loadReturnBooks() {
        returntable.setItems(returnBookService.getallReturnBook());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set Default Date
        txtreturn_date.setText(LocalDate.now().toString());

        // Table Column Mapping
        colreturn_id.setCellValueFactory(new PropertyValueFactory<>("returnId"));
        colrent_id.setCellValueFactory(new PropertyValueFactory<>("rentId"));
        colcustomer_id.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colbook_id.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colreturn_date.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colfine.setCellValueFactory(new PropertyValueFactory<>("fine"));
        colbook_price.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        collate_days.setCellValueFactory(new PropertyValueFactory<>("lateDays"));
        coldailyfee.setCellValueFactory(new PropertyValueFactory<>("dailyLateFee"));
        colextra_fee.setCellValueFactory(new PropertyValueFactory<>("extraFee"));
        colstatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadReturnBooks();

        // Selection Listener
        returntable.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
            if (newvalue != null) {
                txtreturn_id.setText(newvalue.getReturnId());
                txtrent_id.setText(newvalue.getRentId());
                txtcustomer_id.setText(newvalue.getCustomerId());
                txtbook_id.setText(newvalue.getBookId());
                txtreturn_date.setText(newvalue.getReturnDate());
                txtFine.setText(String.valueOf(newvalue.getFine()));
                txtbook_price.setText(String.valueOf(newvalue.getBookPrice()));
                txtlate_days.setText(String.valueOf(newvalue.getLateDays()));
                txtdailylate_fee.setText(String.valueOf(newvalue.getDailyLateFee()));
                txtextra_fee.setText(String.valueOf(newvalue.getExtraFee()));
                txtstatus.setText(newvalue.getStatus());
            }
        });
    }
}