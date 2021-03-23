/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Controller;

/**
 *
 * @author WarSpite
 */
import firstdeliverable.FirstDeliverable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author itwang
 */
public class LoginController implements Initializable {

    private FirstDeliverable application;
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;

    public void setApp(FirstDeliverable application) {
        this.application = application;
    }

    @FXML
    public void loginM(ActionEvent event) {
        application.userlogin(account.getText(), password.getText());
    }

    @FXML
    public void clearM(ActionEvent event) {
        account.setText("");
        password.setText("");
    }

    @FXML
    public void goCreate(ActionEvent event) {
        application.goToCreate();
    }

    @FXML
    public void showUser(ActionEvent event) {
        application.getList().printList();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Hint");
        alert.setContentText("A full list view has been show on the console\nYou can check your username and password in there");
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
