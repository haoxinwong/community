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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author WarSpite
 */
public class ProfileController implements Initializable {

    private FirstDeliverable application;
    @FXML
    private Label userName;
    @FXML
    private Label passID;
    @FXML
    private Text stateField;
    @FXML
    private ImageView picture;

    public void setApp(FirstDeliverable application) {
        this.application = application;
        stateField.setText(application.getCurrentUser().getState());
        userName.setText(application.getCurrentUser().getUserName());
        passID.setText(application.getCurrentUser().getPassID() + "");
        Image imProfile = new Image(getClass().getResourceAsStream(application.getCurrentUser().getProfilePicture()));
        picture.setImage(imProfile);

    }

    @FXML
    public void goPost(ActionEvent event){
        application.goToPost();
    }
    
    @FXML
    public void goMain(ActionEvent event) {
        application.goToMain();
    }

    @FXML
    public void goEditProfile(ActionEvent event) {
        application.goToEditProfile();
    }
    
    @FXML
    public void goForum(ActionEvent event){
        application.goToForum();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
}
