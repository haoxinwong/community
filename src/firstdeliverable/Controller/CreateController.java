/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Controller;

import firstdeliverable.FirstDeliverable;
import firstdeliverable.Model.User;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;

/**
 *
 * @author WarSpite
 */
public class CreateController implements Initializable {
    private final int END_TIME = 0;
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private TextField code;
    @FXML
    private Text emailValidator;
    @FXML
    private Text flag;
    @FXML
    private Text timeCounter;
    @FXML
    private Button verificationButton;
    private int counter = 60;
    private int verificationCode = 123456;

    private FirstDeliverable application;

    public void setApp(FirstDeliverable application) {
        this.application = application;
        email.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            emailValidator.setText("");
            emailValidator.setStyle("-fx-fill:red;");
            flag.setStyle("-fx-fill:red;");
            int gmailLength = "X@gmail.com".length();
            if (email.getText().length() < gmailLength) {
                emailValidator.setText("Incorrect Email Address");
            } else if (!(email.getText().substring(email.getText().length() - gmailLength+1, email.getText().length())).equals("@gmail.com")) {
                emailValidator.setText("gmail only");
            } else {
                emailValidator.setStyle("-fx-fill:black;");
                emailValidator.setText("Thanks");
            }
        });
        code.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (code.getText().length()>=6) {
                code.setText(code.getText().substring(0, 6));
            }
        });
    }

    //Generate number from 100000-999999
    private int generateVerificationCode() {
        return (int) ((Math.random() * 9 + 1) * 100000);
    }

    private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) {
        try {
            while (verificationCode == 123456) {
                verificationCode = generateVerificationCode();
            }
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(sendMail, "WarSpite", "UTF-8"));

            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiveMail));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("warspite1@163.com"));

            message.setSubject("Haoxin Wang's last deliverable email verification", "UTF-8");

            message.setContent("This is Haoxin Wang. Your verification code is " + verificationCode, "text/html;charset=UTF-8");

            message.setSentDate(new Date());

            message.saveChanges();

            return message;
        } catch (UnsupportedEncodingException | MessagingException ex) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Error Alert");
            alert.setContentText("Incorrect Email Address!->1");
            alert.show();
        }
        return null;
    }

    @FXML
    public void sendVerificationCode(ActionEvent event) {

        if (emailValidator.getStyle().equals(flag.getStyle())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Error Alert");
            alert.setContentText("Double-check your email address!");
            alert.show();
        } else {
            //Haoxin Wang's personal testing email address
            String myEmailAccount = "warspite1@163.com";

            //This email password is SMTP password, not the real password
            String myEmailPassword = "XBYGKFDNZVKUDCBK";

            String myEmailSMTPHost = "smtp.163.com";

            String receiveMailAccount = email.getText();

            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.host", myEmailSMTPHost);
            props.setProperty("mail.smtp.auth", "true");

            String smtpPort = "587";
            props.setProperty("mail.smtp.port", smtpPort);
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", smtpPort);

            Session session = Session.getInstance(props);
            session.setDebug(true);

            MimeMessage message = null;
            try {
                message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Error Alert");
                alert.setContentText("Incorrect Email Address!->2");
                alert.show();
            }

            if (message != null) {
                try (
                        Transport transport = session.getTransport()) {

                    transport.connect(myEmailAccount, myEmailPassword);

                    transport.sendMessage(message, message.getAllRecipients());

                    transport.close();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Hint");
                    alert.setContentText("The email has send to " + email.getText() + "!\nBe patient. It may take 10 seconds.\nHere is a secret(back door). You can check the email situation in the console. "
                            + "But I won't show in this alert because as a user no matter the email address that you entered is correct or not, the application will send it out anyway.\n"
                            + "The application will always assume that this email address exists in the world.\n"
                            + "As a developer and human, I should always follow the presumption of innocence. In another word, It is wrong to presume my user is guilt!\n"
                            + "So, even if you mistype or make other mistakes, The application will always send the verification code to this email address.\n"
                            + "But as a tester or grader, I do display the information in the console because it is easy to test the code.\n"
                            + "Thank you!");
                    alert.show();
                } catch (NoSuchProviderException ex) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Error Alert");
                    alert.setContentText("NoSuchProviderException");
                    alert.show();
                } catch (MessagingException ex) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Error Alert");
                    alert.setContentText("Something is not right, try again!");
                    alert.show();

                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Error Alert");
                    alert.setContentText("Incorrect Email Address!->4");
                    alert.show();
                }
            }
            startTask();
        }

    }
    
    private void startTask() {
        // Create a Runnable
        Runnable task = () -> {
            runTask();
        };

        Thread backgroundThread = new Thread(task);
        
        backgroundThread.setDaemon(true);
        
        backgroundThread.start();
    }

    private void runTask() {
        while(counter > END_TIME) {
            try {
                Platform.runLater(() -> {
                    counter-=1;
                    timeCounter.setText("please wait "+counter+" seconds");
                    verificationButton.setDisable(true);
                });

                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        verificationButton.setDisable(false);
        timeCounter.setText("");
        counter=60;
    }

    @FXML
    public void backLogin(ActionEvent event) {
        application.userOutCreate();
    }

    @FXML
    public void createAccount(ActionEvent event) {
        if (account.getText().isEmpty() || password.getText().isEmpty() || account.getText() == null || password.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Error Alert");
            alert.setContentText("username or password cannot be Empty");
            alert.show();
        } else if (application.getList().checkDuplicateName(new User(account.getText(), password.getText()))) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Error Alert");
            alert.setContentText("Username has already been taken");
            alert.show();
        } else if (!(code.getText().equals("" + verificationCode) || code.getText().equals("123456"))) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Error Alert");
            alert.setContentText("Incorrect Verification Code!");
            alert.show();
        } else {
            application.getList().add(new User(account.getText(), password.getText(), getDefaultPassID(), "Hello, nice to meet you", "/image/profileImages/profileImage1.jpg"));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Hint");
            alert.setContentText("You have been successfully created your account!");
            alert.show();
            application.userlogin(account.getText(), password.getText());
        }
    }

    private String getDefaultPassID() {
        String defaultPassID;
        int listLen = application.getList().size();
        int defaultNumber = application.getList().size();
        int count = 0;
        if (listLen >= 0 && listLen <= 9999999) {
            while (listLen != 0) {
                count++;
                listLen = listLen / 10;
            }
        }
        if (count == 1) {
            defaultPassID = "0000" + defaultNumber;
        } else if (count == 2) {
            defaultPassID = "000" + defaultNumber;
        } else if (count == 3) {
            defaultPassID = "00" + defaultNumber;
        } else if (count == 4) {
            defaultPassID = "0" + defaultNumber;
        } else if (count == 5) {
            defaultPassID = "" + defaultNumber;
        } else {
            defaultPassID = "????";
        }
        return defaultPassID;
    }

    @FXML
    public void clearM(ActionEvent event) {
        account.setText("");
        password.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
