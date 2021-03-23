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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author WarSpite
 */
public class EditAvatarController implements Initializable {

    private FirstDeliverable application;
    private String imageFile = "";
    @FXML
    private ImageView picture;

    public void setApp(FirstDeliverable application) {
        this.application = application;
        imageFile = application.getCurrentUser().getProfilePicture();
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void outEditAvatar(ActionEvent event) {
        application.userOutEditAvatar();
    }

    @FXML
    public void change1(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage1.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change2(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage2.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change3(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage3.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change4(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage4.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change5(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage5.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change6(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage6.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change7(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage7.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change8(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage8.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change9(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage9.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change10(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage10.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change11(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage11.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change12(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage12.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change13(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage13.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change14(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage14.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change15(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage15.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change16(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage16.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change17(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage17.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change18(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage18.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change19(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage19.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change20(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage20.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void change21(MouseEvent event) {
        imageFile = "/image/profileImages/profileImage21.jpg";
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        picture.setImage(imProfile);
    }

    @FXML
    public void saveAvatar(ActionEvent event) {
        application.getList().get(application.getCurrentUserNumber()).setProfilePicture(imageFile);
        application.setCurrentUser(application.getList().get(application.getCurrentUserNumber()));
        application.updateInfo();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Hint");
        alert.setContentText("You have been successfully changed your avatar!");
        alert.show();
        application.userOutEditAvatar();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
