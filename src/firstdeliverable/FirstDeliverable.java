/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable;

import firstdeliverable.Controller.ProfileController;
import firstdeliverable.Controller.EditAvatarController;
import firstdeliverable.Controller.LoginController;
import firstdeliverable.Controller.EditProfileController;
import firstdeliverable.Controller.MainController;
import firstdeliverable.Controller.CreateController;
import firstdeliverable.Controller.ForumController;
import firstdeliverable.Controller.GeneralForumController;
import firstdeliverable.Controller.PostController;
import firstdeliverable.Controller.PostDetailController;
import firstdeliverable.Controller.SectionsController;
import firstdeliverable.Model.LolMidendTranslator;
import firstdeliverable.Model.Post;
import firstdeliverable.Model.TempPost;
import firstdeliverable.Model.User;
import firstdeliverable.Model.UserList;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Haoxin Wang (WarSpite) 
 */
public class FirstDeliverable extends Application {

    private UserList list = new UserList();
    private int forumNumber = 0;
    private LolMidendTranslator translator = new LolMidendTranslator(forumNumber);
    private User currentUser = new User("Haoxin", "wang", "-000001", "wwwww", "/image/profileImages/profileImage1.jpg");
    private int currentUserNumber = -1;
    private int currentPostNumber = -1;
    private TempPost tempPost;
    private Post currentPost;
    private Stage stage;
    private boolean hasTempPost = false;
    private final double MINIMUM_WINDOW_WIDTH = 300;
    private final double MINIMUM_WINDOW_HEIGHT = 400.0;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("This is the last deliverable");
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        goToLogin();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

        stage.show();
    }

    public void goToSections() {
        try {
            SectionsController sections = (SectionsController) replaceSceneContent("View/FXML_SECTIONS.fxml");
            sections.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToPost() {
        try {
            PostController post = (PostController) replaceSceneContent("View/FXML_POST.fxml");
            post.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToPostDetail() {
        try {
            PostDetailController postDetail = (PostDetailController) replaceSceneContent("View/FXML_POSTDETAIL.fxml");
            postDetail.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToGeneralForum() {
        try {
            GeneralForumController generalforum = (GeneralForumController) replaceSceneContent("View/FXML_GENERALFORUM.fxml");
            generalforum.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToForum() {
        try {
            ForumController forum = (ForumController) replaceSceneContent("View/FXML_FORUM.fxml");
            forum.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToEditAvatar() {
        try {
            EditAvatarController editAvatar = (EditAvatarController) replaceSceneContent("View/FXML_EDITAVATAR.fxml");
            editAvatar.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToEditProfile() {
        try {
            EditProfileController editProfile = (EditProfileController) replaceSceneContent("View/FXML_EDITPROFILE.fxml");
            editProfile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToCreate() {
        try {
            CreateController create = (CreateController) replaceSceneContent("View/FXML_CREATE.fxml");
            create.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("View/FXML_LOGIN.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToMain() {
        try {
            MainController main = (MainController) replaceSceneContent("View/FXML_MAIN.fxml");
            main.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goToProfile() {
        try {
            ProfileController profile = (ProfileController) replaceSceneContent("View/FXML_PROFILE.fxml");
            profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userlogin(String account, String password) {
        int number = 0;
        if (list.checkUser(account, password)) {
            for (User u : list.getUserList()) {
                if (u.getUserName().equals(account) && u.getPassword().equals(password)) {
                    currentUser = u;
                    currentUserNumber = number;
                    break;
                }
                number++;
            }
            goToMain();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Error Alert");
            alert.setContentText("Wrong account number or password, redo");
            alert.show();
        }
    }

    public void updateInfo() {
        if (!currentUser.isEmptyPost()) {
            currentUser.getMyPostList().get("General");
            currentUser.getMyPostList().entrySet().forEach((m) -> {
                for (int i : m.getValue()) {
                    for (Post p : translator.getAccessData(m.getKey())) {
                        if (p.getPostNumber() == i) {
                            p.setUser(currentUser);
                        }
                    }
                }
            });
        }

    }

    public void userOutPostDetailFromGeneral() {
        goToGeneralForum();
    }

    public void userOutMain() {
        list.saveData(currentUserNumber, currentUser);
        this.currentUser = null;
        goToLogin();
    }

    public void userOutCreate() {
        goToLogin();
    }

    public void userOutEditProfile() {
        goToProfile();
    }

    public void userOutEditAvatar() {
        goToEditProfile();
    }

    public void userOutGeneral() {
        goToForum();
    }

    public void userOutPostDetail() {
        goToGeneralForum();
    }

    public void userOutSections() {
        goToPost();
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = FirstDeliverable.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(FirstDeliverable.class.getResource(fxml));
        try {
            AnchorPane page = (AnchorPane) loader.load(in);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            stage.sizeToScene();
        } catch (IOException e) {
            Logger.getLogger(FirstDeliverable.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (in != null) {
                in.close();
            }
        }

        return (Initializable) loader.getController();

    }

    public UserList getList() {
        return list;
    }

    public void setList(UserList list) {
        this.list = list;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public int getCurrentPostNumber() {
        return currentPostNumber;
    }

    public void setCurrentPostNumber(int currentPostNumber) {
        this.currentPostNumber = currentPostNumber;
    }

    public Post getCurrentPost() {
        return currentPost;
    }

    public void setCurrentPost(Post currentPost) {
        this.currentPost = currentPost;
    }

    public int getCurrentUserNumber() {
        return currentUserNumber;
    }

    public void setCurrentUserNumber(int currentUserNumber) {
        this.currentUserNumber = currentUserNumber;
    }

    public LolMidendTranslator getTranslator() {
        return translator;
    }

    public void setTranslator(LolMidendTranslator translator) {
        this.translator = translator;
    }

    public int getForumNumber() {
        return forumNumber;
    }

    public void setForumNumber(int forumNumber) {
        this.forumNumber = forumNumber;
    }

    public TempPost getTempPost() {
        return tempPost;
    }

    public void setTempPost(TempPost tempPost) {
        this.tempPost = tempPost;
    }

    public boolean isHasTempPost() {
        return hasTempPost;
    }

    public void setHasTempPost(boolean hasTempPost) {
        this.hasTempPost = hasTempPost;
    }

}
