/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Controller;

import firstdeliverable.FirstDeliverable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author WarSpite
 */
public class EditProfileController implements Initializable {

    private FirstDeliverable application;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextArea stateField;
    @FXML
    private ImageView picture;

    public void setApp(FirstDeliverable application) {
        this.application = application;
        usernameField.setText(application.getCurrentUser().getUserName());
        passwordField.setText(application.getCurrentUser().getPassword());
        stateField.setText(application.getCurrentUser().getState());
        Image imProfile = new Image(getClass().getResourceAsStream(application.getCurrentUser().getProfilePicture()));
        picture.setImage(imProfile);
    }

    @FXML
    public void outEditProfile(ActionEvent event) {
        application.userOutEditProfile();
    }

    @FXML
    public void saveData(ActionEvent event) {
        if (checkMaxLetters(stateField.getText())) {
            application.getList().get(application.getCurrentUserNumber()).setPassword(passwordField.getText());
            application.getList().get(application.getCurrentUserNumber()).setState(stateField.getText());
            application.setCurrentUser(application.getList().get(application.getCurrentUserNumber()));
            application.updateInfo();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Hint");
            alert.setContentText("You have been successfully saved your changes!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Error");
            alert.setContentText("Sorry, you entered more than 200 letters");
            alert.show();
        }
    }

    private boolean checkMaxLetters(String s) {
        return s.length() <= 200;
    }

    @FXML
    public void changeAvatar(ActionEvent event) {
        application.goToEditAvatar();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
