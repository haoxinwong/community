/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WarSpite
 */
public class User {
    private String userName;
    private String password;
    private String passID;
    private String state;
    private String profilePicture;
    private Map<String,List<Integer>> myPostList;

    public User(String userName, String password, String passID, String state, String profilePicture) {
        this.userName = userName;
        this.password = password;
        this.passID = passID;
        this.state = state;
        this.profilePicture = profilePicture;
        this.myPostList = new HashMap<>();
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassID() {
        return passID;
    }

    public void setPassID(String passID) {
        this.passID = passID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Map<String, List<Integer>> getMyPostList() {
        return myPostList;
    }

    public void setMyPostList(Map<String, List<Integer>> myPostList) {
        this.myPostList = myPostList;
    }

    public boolean isEmptyPost(){
        return myPostList.isEmpty();
    }
    
}
