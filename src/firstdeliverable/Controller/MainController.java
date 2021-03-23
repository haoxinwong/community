/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Controller;

import firstdeliverable.FirstDeliverable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author WWWWarSpite
 */
public class MainController implements Initializable {

    private FirstDeliverable application;
    @FXML
    private ImageView ad1;
    @FXML
    private ImageView ad2;
    @FXML
    private ImageView ad3;
    @FXML
    private ImageView ad4;
    @FXML
    private Shape circleButton1;
    @FXML
    private Shape circleButton2;
    @FXML
    private Shape circleButton3;
    @FXML
    private Shape circleButton4;
    private int currentNumber = 0;
    private boolean thread1Flag = true;
    private int thread1SleepTime = 2000;

    private final Thread thread1;

    public MainController() {
        this.thread1 = new Thread() {
            @Override
            public void run() {

                while (thread1Flag) {
                    if (currentNumber == 4) {
                        currentNumber = 1;
                    } else {
                        currentNumber++;
                    }

                    switch (currentNumber) {
                        case 1:
                            image1();
                            break;
                        case 2:
                            image2();
                            break;
                        case 3:
                            image3();
                            break;
                        case 4:
                            image4();
                            break;
                    }
                    try {
                        Thread.sleep(thread1SleepTime);
                        thread1SleepTime = 2000;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        };
    }

    public void setApp(FirstDeliverable application) {
        this.application = application;
        thread1.start();
    }

    @FXML
    public void goPost(ActionEvent event) {
        application.goToPost();
    }

    @FXML
    public void goOfficial1(MouseEvent event) {
        application.getTranslator().Selector(1);
        application.setCurrentPost(application.getTranslator().getAccessData("Official").get(0));
        application.goToPostDetail();
    }

    @FXML
    public void goOfficial2(MouseEvent event) {
        application.getTranslator().Selector(1);
        application.setCurrentPost(application.getTranslator().getAccessData("Official").get(1));
        application.goToPostDetail();
    }

    @FXML
    public void goOfficial3(MouseEvent event) {
        application.getTranslator().Selector(1);
        application.setCurrentPost(application.getTranslator().getAccessData("Official").get(2));
        application.goToPostDetail();
    }

    @FXML
    public void goOfficial4(MouseEvent event) {
        application.getTranslator().Selector(1);
        application.setCurrentPost(application.getTranslator().getAccessData("Official").get(3));
        application.goToPostDetail();
    }

    @FXML
    public void outMain(ActionEvent event) {
        application.userOutMain();
        thread1Flag = false;
    }

    @FXML
    public void goForum(ActionEvent event) {
        application.goToForum();
        thread1Flag = false;
    }

    @FXML
    public void goProfile(ActionEvent event) {
        application.goToProfile();
        thread1Flag = false;

    }

    private void image1() {
        circleButton1.setFill(Color.MEDIUMTURQUOISE);
        circleButton2.setFill(Color.WHITE);
        circleButton3.setFill(Color.WHITE);
        circleButton4.setFill(Color.WHITE);
        ad1.setVisible(true);
        ad2.setVisible(false);
        ad3.setVisible(false);
        ad4.setVisible(false);
        currentNumber = 1;
    }

    @FXML
    public void showImage1(MouseEvent event) {
        image1();
    }

    private void image2() {
        circleButton1.setFill(Color.WHITE);
        circleButton2.setFill(Color.MEDIUMTURQUOISE);
        circleButton3.setFill(Color.WHITE);
        circleButton4.setFill(Color.WHITE);
        ad1.setVisible(false);
        ad2.setVisible(true);
        ad3.setVisible(false);
        ad4.setVisible(false);
        currentNumber = 2;
    }

    @FXML
    public void showImage2(MouseEvent event) {
        image2();
    }

    private void image3() {
        circleButton1.setFill(Color.WHITE);
        circleButton2.setFill(Color.WHITE);
        circleButton3.setFill(Color.MEDIUMTURQUOISE);
        circleButton4.setFill(Color.WHITE);
        ad1.setVisible(false);
        ad2.setVisible(false);
        ad3.setVisible(true);
        ad4.setVisible(false);
        currentNumber = 3;
    }

    @FXML
    public void showImage3(MouseEvent event) {
        image3();
    }

    private void image4() {
        circleButton1.setFill(Color.WHITE);
        circleButton2.setFill(Color.WHITE);
        circleButton3.setFill(Color.WHITE);
        circleButton4.setFill(Color.MEDIUMTURQUOISE);
        ad1.setVisible(false);
        ad2.setVisible(false);
        ad3.setVisible(false);
        ad4.setVisible(true);
        currentNumber = 4;
    }

    @FXML
    public void showImage4(MouseEvent event) {
        image4();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
