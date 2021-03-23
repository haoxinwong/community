/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Controller;

import firstdeliverable.FirstDeliverable;
import firstdeliverable.Model.TempPost;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author WarSpite
 */
public class SectionsController implements Initializable {
    private FirstDeliverable application;
    public void setApp(FirstDeliverable application) {
        this.application = application;
    }

    @FXML
    public void outSections(ActionEvent event) {
        if(application.getTempPost()==null){
            application.setHasTempPost(false);
        }else{
            application.setHasTempPost(true);
        }
        application.userOutSections(); 
    }
    
    @FXML
    public void setGeneral(ActionEvent event){
        if(application.getTempPost()==null){
            application.setTempPost(new TempPost());
        }
        application.getTempPost().setForum("General");
        if(application.getTempPost().getDescription()==null||application.getTempPost().getDescription().length()==0){
            application.getTempPost().setDescription("");
        }
        if(application.getTempPost().getTitle()==null||application.getTempPost().getTitle().length()==0){
            application.getTempPost().setTitle("");
        }
        application.setHasTempPost(true);
        application.userOutSections(); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
