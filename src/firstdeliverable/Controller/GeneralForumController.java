/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Controller;

import firstdeliverable.FirstDeliverable;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author WarSpite
 */
public class GeneralForumController implements Initializable {

    private FirstDeliverable application;
    @FXML
    private Label introLabel;
    @FXML
    private Button category1;
    @FXML
    private Button category2;
    @FXML
    private Button category3;
    @FXML
    private ListView<String> listView;
    private final ObservableList<String> list = FXCollections.observableArrayList();

    public void setApp(FirstDeliverable application) {
        this.application = application;
        initializeData();
        initializeListView();
    }

    private void initializeData() {
        introLabel.setText("Introduction: " + application.getTranslator().getForumIntro(0));
        category1.setText("# " + application.getTranslator().getForumCategory(application.getForumNumber() - 1).get(0));
        category2.setText("# " + application.getTranslator().getForumCategory(application.getForumNumber() - 1).get(1));
        category3.setText("# " + application.getTranslator().getForumCategory(application.getForumNumber() - 1).get(2));
    }

    private void initializeListView() {
        for (int i = 0; i < this.application.getTranslator().getShowList().size(); i++) {
            String des = this.application.getTranslator().getShowList().get(i).getDecription();
            des = des.replaceAll("\n", " ");
            if (this.application.getTranslator().getShowList().get(i).getDecription().length() > 40) {
                des = des.substring(0, 50) + "...";
            }
            String a = this.application.getTranslator().getShowList().get(i).getUser().getUserName() + "   "
                    + this.application.getTranslator().getShowList().get(i).getDate().get(Calendar.YEAR)
                    + "/" + this.application.getTranslator().getShowList().get(i).getDate().get(Calendar.MONTH)
                    + "/" + this.application.getTranslator().getShowList().get(i).getDate().get(Calendar.DAY_OF_MONTH)
                    + "-" + this.application.getTranslator().getShowList().get(i).getDate().get(Calendar.HOUR)
                    + ":" + this.application.getTranslator().getShowList().get(i).getDate().get(Calendar.MINUTE) + "\n\t" + this.application.getTranslator().getShowList().get(i).getTitle()
                    + "\n  " + des;
            list.add(a);
        }
        listView.setItems(list);
    }

    @FXML
    public void outGeneral(ActionEvent event) {
        application.userOutGeneral();
    }

    @FXML
    public void goPost(MouseEvent event) {
        application.setCurrentPost(application.getTranslator().getAccessData("General").get(listView.getSelectionModel().getSelectedIndex()));
        application.setCurrentPostNumber(listView.getSelectionModel().getSelectedIndex());
        application.goToPostDetail();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
