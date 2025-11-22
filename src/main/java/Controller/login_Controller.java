package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class login_Controller {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPassword;

    @FXML
    void btn_Login_On_Action(ActionEvent event) {
        Stage stage=new Stage();
        String name=txtName.getText();
        String password=txtPassword.getText();
        if (name.equals("rasika")&& password.equals("2005")){


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("Login in Sucessfully !!!!");
            alert.showAndWait();



            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(""))));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else {


        }


    }

}
