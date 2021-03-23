/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WarSpite
 */
public class UserList {
    private List<User>userList;

    public UserList() {
        this.userList = new ArrayList<>();
        addUsers();
    }

    private void addUsers(){
        String general = "General";
        String official = "Official";
        User w = new User("w","w","00000","Hello, I am the first tester. My username is w, and the password is w too. The reason that I set my username and password like this is for the efficiency of testing.","/image/profileImages/profileImage20.jpg");
        Map <String,List<Integer>>map1 = new HashMap<>();
        Map <String,List<Integer>>map2 = new HashMap<>();
        Map <String,List<Integer>>map3 = new HashMap<>();
        List<Integer>list1 = new ArrayList<>();
        List<Integer>list2 = new ArrayList<>();
        List<Integer>list3 = new ArrayList<>();
        List<Integer>list4 = new ArrayList<>();
        list1.add(0);
        map1.put(general, list1);
        map1.put(official,  list1);
        w.setMyPostList(map1);
        userList.add(w);
        
        User b = new User("b","b","00001","Hello, I am John","/image/profileImages/profileImage1.jpg");
        list2.add(1);
        map2.put(general, list2);
        map2.put(official,  list2);
        b.setMyPostList(map2);
        userList.add(b);
        
        User a = new User("a","a","00002","Hello, I am Levi","/image/profileImages/profileImage1.jpg");
        list3.add(2);
        map3.put(general,list3);
        list4.add(2);
        list4.add(3);
        map3.put(official, list4);
        a.setMyPostList(map3);
        userList.add(a);
    }
    
    public UserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    public int size() {
        return userList.size();
    }

    public boolean isEmpty() {
        return userList.isEmpty();
    }

    public User get(int index) {
        return userList.get(index);
    }

    public void printList() {
        userList.forEach((d) -> {
            System.out.println(d.getUserName()+ ":" + d.getPassword());
        });
    }
    
    public boolean checkUser(String name, String passWord){
        if (userList.stream().anyMatch((u) -> (u.getUserName().equals(name)&&u.getPassword().equals(passWord)))) {
            return true;
        }
        return false;
    }
    
    public void removeElement(int i){
        userList.remove(i);
    }
    //return true if the name of the user are the same
    public boolean checkDuplicateName(User user){
        for(User u:userList){
            if(u.getUserName().equals(user.getUserName())){
                return true;
            }
        }
        return false;
    }
    
    public void add(User user) {
        userList.add(user);
    }
    
    public void saveData(int num, User user){
        userList.get(num).setPassID(user.getPassID());
        userList.get(num).setPassword(user.getPassword());
        userList.get(num).setProfilePicture(user.getProfilePicture());
        userList.get(num).setState(user.getState());
        userList.get(num).setUserName(user.getUserName());
    }
}
