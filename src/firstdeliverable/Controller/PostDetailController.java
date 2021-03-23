/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Controller;

import firstdeliverable.FirstDeliverable;
import firstdeliverable.Model.Reply;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author WarSpite
 */
public class PostDetailController implements Initializable {

    private FirstDeliverable application;
    @FXML
    private Label username;
    @FXML
    private Label title;
    @FXML
    private Label date;
    @FXML
    private Text descriptionArea;
    @FXML
    private ListView<String> listReply;
    @FXML
    private TextField replyField;
    @FXML
    private Label view;
    @FXML
    private ImageView userPicture;

    private String imageFile;
    private final Calendar calendar = new GregorianCalendar();
    private final ObservableList<String> listP = FXCollections.observableArrayList();

    public void setApp(FirstDeliverable application) {
        this.application = application;
        imageFile = application.getCurrentPost().getUser().getProfilePicture();
        Image imProfile = new Image(getClass().getResourceAsStream(imageFile));
        userPicture.setImage(imProfile);
        this.username.setText(this.application.getCurrentPost().getUser().getUserName());
        this.title.setText(this.application.getCurrentPost().getTitle());
        this.view.setText(this.application.getCurrentPost().getPostView() + "");
        this.date.setText(this.application.getCurrentPost().getDate().get(Calendar.YEAR)
                + "/" + this.application.getCurrentPost().getDate().get(Calendar.MONTH)
                + "/" + this.application.getCurrentPost().getDate().get(Calendar.DAY_OF_MONTH)
                + "-" + this.application.getCurrentPost().getDate().get(Calendar.HOUR)
                + ":" + this.application.getCurrentPost().getDate().get(Calendar.MINUTE));
        this.descriptionArea.setText(this.application.getCurrentPost().getDecription());
        if (!(this.application.getCurrentPost().getReplys() == null) && !(this.application.getCurrentPost().getReplys().size() <= 0)) {
            for (int i = 0; i < this.application.getCurrentPost().getReplys().size(); i++) {
                String a = this.application.getCurrentPost().getReplys().get(i).getRespondent().getUserName() + "   "
                        + this.application.getCurrentPost().getReplys().get(i).getDate().get(Calendar.YEAR)
                        + "/" + this.application.getCurrentPost().getReplys().get(i).getDate().get(Calendar.MONTH)
                        + "/" + this.application.getCurrentPost().getReplys().get(i).getDate().get(Calendar.DAY_OF_MONTH)
                        + "-" + this.application.getCurrentPost().getReplys().get(i).getDate().get(Calendar.HOUR)
                        + ":" + this.application.getCurrentPost().getReplys().get(i).getDate().get(Calendar.MINUTE)
                        + "\n" + this.application.getCurrentPost().getReplys().get(i).getReplyText();
                listP.add(a);
            }
            listReply.setCellFactory((final ListView<String> list) -> new ListCell<String>() {
                
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.toUpperCase());
                    }
                }
                
                {
                    Text text = new Text();
                    text.wrappingWidthProperty().bind(list.widthProperty().subtract(15));
                    text.textProperty().bind(itemProperty());
                    setPrefWidth(0);
                    setGraphic(text);
                }
                
            });
            listReply.setItems(listP);
        }
    }

    @FXML
    public void outPostDetail(ActionEvent event) {
        this.application.getCurrentPost().setPostView(this.application.getCurrentPost().getPostView() + 1);
        if (this.application.getCurrentPost().getForum().equals("General")) {
            application.userOutPostDetailFromGeneral();
        } else if (this.application.getCurrentPost().getForum().equals("Official")) {
            application.goToMain();
        }
    }
    
    @FXML
    public void reply(ActionEvent event) {
        Alert alert;
        if (replyField.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Error");
            alert.setContentText("I am sorry, unacceptable empty String");
            alert.show();
        } else {
            this.application.getCurrentPost().addReply(new Reply(this.application.getCurrentUser(), calendar, replyField.getText()));
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Hint");
            alert.setContentText("You have been successfully reply to a person!");
            alert.show();
            this.application.getCurrentPost().setNewestEdit(calendar);
            this.application.getTranslator().refreshList("General");
            this.application.goToPostDetail();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
