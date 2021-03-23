/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Controller;

import firstdeliverable.FirstDeliverable;
import firstdeliverable.Model.Post;
import firstdeliverable.Model.PostCategory;
import firstdeliverable.Model.TempPost;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author WarSpite
 */
public class PostController implements Initializable{

    private FirstDeliverable application;
    @FXML
    private TextField selection;
    @FXML
    private TextField title;
    @FXML
    private Text titleCounter;
    @FXML
    private TextArea description;
    
    private final Alert alert = new Alert(AlertType.CONFIRMATION);
    private final Calendar calendar = new GregorianCalendar();
    
    public void setApp(FirstDeliverable application) {
        this.application = application;
        createAlert();
        title.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            titleCounter.setText(title.getText().length()+"/50");
            if(title.getText().length()>50){
                titleCounter.setStyle("-fx-fill:red;");
            }else{
                titleCounter.setStyle("-fx-fill:black;");
            }
        });
        if(this.application.isHasTempPost()){
            if(application.getTempPost().getTitle()==null){
            }else{
                title.setText(this.application.getTempPost().getTitle());
            }
            if(this.application.getTempPost().getDescription()!=null){
                description.setText(this.application.getTempPost().getDescription());
            }
            if(this.application.getTempPost().getForum()!=null){
                selection.setText(this.application.getTempPost().getForum());
            }
        }
    }
    
    @FXML
    public void goSections(ActionEvent event){
        if(title.getText().length()>0&&description.getText().length()>0){
            application.setTempPost(new TempPost(title.getText(),description.getText()));
        }else if(title.getText().length()==0&&description.getText().length()>0){
            application.setTempPost(new TempPost(description.getText(),1));
        }else if(title.getText().length()>0&&description.getText().length()==0){
            application.setTempPost(new TempPost(title.getText(),0));
        }
        application.goToSections();
    }
    @FXML
    public void goMain(ActionEvent event) {
        if(hasInfo()){
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                application.setTempPost(null);
                application.setHasTempPost(false);
                application.goToMain();
            }
        }else{
            application.setTempPost(null);
            application.setHasTempPost(false);
            application.goToMain();
        }
    }

    @FXML
    public void goProfile(ActionEvent event) {
        if(hasInfo()){
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                application.setTempPost(null);
                application.setHasTempPost(false);
                application.goToProfile();
            }
        }else{
            application.setTempPost(null);
            application.setHasTempPost(false);
            application.goToProfile();
        }
    }
    
    
    @FXML
    public void goForum(ActionEvent event){
        if(hasInfo()){
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                application.setTempPost(null);
                application.setHasTempPost(false);
                application.goToForum();
            }
        }else{
            application.setTempPost(null);
            application.setHasTempPost(false);
            application.goToForum();
        }
    }
    
    @FXML
    public void send(ActionEvent event){
        Alert sendAlert = new Alert(Alert.AlertType.CONFIRMATION);
        if(hasFullInfo()){
            if(title.getText().length()<=50){
                if(description.getText().length()<=10000){
                    application.getTranslator().getAccessData(selection.getText()).
                            add(new Post(title.getText(),
                                    description.getText(),
                                    calendar,
                                    application.getCurrentUser(),
                                    application.getTranslator().getAccessData(selection.getText()).size(),
                                    new PostCategory(),
                                    selection.getText()
                            ));
                    application.getList().get(application.getCurrentUserNumber()).getMyPostList().get(selection.getText()).add(application.getTranslator().getAccessData(selection.getText()).size());
                    application.setCurrentUser(application.getList().get(application.getCurrentUserNumber()));
                    application.updateInfo();
                    sendAlert.setHeaderText("Hint");
                    sendAlert.setContentText("You have been successfully send your post, and I will bring you to the forum!");
                    sendAlert.show();
                    application.setTempPost(null);
                    application.setHasTempPost(false);
                    application.goToForum();
                }else{
                    sendAlert.setHeaderText("Error Alert");
                    sendAlert.setContentText("description cannot be more than 10000 letters");
                    sendAlert.show();
                }
            }else{
                sendAlert.setHeaderText("Error Alert");
                sendAlert.setContentText("title cannot be more than 50 letters");
                sendAlert.show();
            }
        }else{
            sendAlert.setHeaderText("Error Alert");
            sendAlert.setContentText("title, description and selection cannot be Empty");
            sendAlert.show();
        }
    }
    private void createAlert(){
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("I am not gonna save your post if you leave this page. Are you ok with this?");
    }
    
    private boolean hasFullInfo(){
        if((title.getText()!=null&&title.getText().length()>0)&&(selection.getText()!=null&&selection.getText().length()>0)&&(description.getText()!=null&&description.getText().length()>0)){
             return true;
        }
        return false;
    }
    
    private boolean hasInfo(){
        if((title.getText()!=null&&title.getText().length()>0)||(selection.getText()!=null&&selection.getText().length()>0)||(description.getText()!=null&&description.getText().length()>0)){
            return true;
        }
        return false;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
