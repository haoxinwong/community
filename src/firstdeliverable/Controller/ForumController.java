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

/**
 *
 * @author WarSpite
 */
public class ForumController implements Initializable {
    private FirstDeliverable application;
    
    @FXML
    private Label boardName;
    @FXML
    private Label generalLabel;
    @FXML
    private Label officialLabel;
    @FXML
    private Label generalPopularity;
    @FXML
    private Label officialPopularity;
    @FXML
    private ImageView generalIcon;
    @FXML
    private ImageView officialIcon;
    private String imageFile = "";
    
    public void setApp(FirstDeliverable application) {
        this.application = application;
        boardName.setText(application.getTranslator().getName());
        initialData();
    }

    private void initialData(){
        imageFile = application.getTranslator().getForumIcon(0);
        Image image1 = new Image(getClass().getResourceAsStream(imageFile));
        generalIcon.setImage(image1);
        
        imageFile = application.getTranslator().getForumIcon(1);
        Image image2 = new Image(getClass().getResourceAsStream(imageFile));
        officialIcon.setImage(image2);

        generalLabel.setText(application.getTranslator().getForumName(0));
        officialLabel.setText(application.getTranslator().getForumName(1));
        
        generalPopularity.setText("Popularity: "+application.getTranslator().getForumSize(0));
        officialPopularity.setText("Popularity: "+application.getTranslator().getForumSize(1));
    }
    
    @FXML
    public void goProfile(ActionEvent event) {
        application.goToProfile();
    }
    
    @FXML
    public void goMain(ActionEvent event) {
        application.goToMain();
    }
    
    @FXML
    public void goPost(ActionEvent event){
        application.goToPost();
    }
    @FXML
    public void goGeneral(ActionEvent event){
        application.goToGeneralForum();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
