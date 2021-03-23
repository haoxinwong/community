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
public class LolBulletinBoard {
    private String name = "League of Legend";
    private final List<String>keysets = new ArrayList<>();
    private Map<String,PostList> bulletinBoard = new HashMap<>();
    private LolOfficialPostList officialPostList = new LolOfficialPostList();
    private LolGeneralPostList generalPostList = new LolGeneralPostList();
    
    
    public LolBulletinBoard() {
        initializeData();
    }
    
    private void initializeData(){
        keysets.add("General");
        keysets.add("Official");
       
        bulletinBoard.put(keysets.get(0), generalPostList);
        bulletinBoard.put(keysets.get(1), officialPostList);
    }

    public Map<String, PostList> getBulletinBoard() {
        return bulletinBoard;
    }

    public void setBulletinBoard(Map<String, PostList> bulletinBoard) {
        this.bulletinBoard = bulletinBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Post> getPictureList(){
        return bulletinBoard.get("Picture").getSortedPostList();
    }
    
    public List<Post> getGeneralList(){
        return bulletinBoard.get("General").getSortedPostList();
    }
    
    public List<Post> getOfficialList(){
        return bulletinBoard.get("Official").getSortedPostList();
    }

    public PostList getOfficialPostList() {
        return officialPostList;
    }

    public void setOfficialPostList(LolOfficialPostList officialPostList) {
        this.officialPostList = officialPostList;
    }

    public PostList getGeneralPostList() {
        return generalPostList;
    }

    public void setGeneralPostList(LolGeneralPostList generalPostList) {
        this.generalPostList = generalPostList;
    }
    
    public String getForumName(int i){
        return keysets.get(i);
    }
    
    public String getForumIcon(int i){
        if(i==0){
            return bulletinBoard.get("General").getIcon();
        }else {
            return bulletinBoard.get("Official").getIcon();
        }
    }
    
    public int getForumSize(int i){
        if(i==0){
            return bulletinBoard.get("General").size();
        }else{
            return bulletinBoard.get("Official").size();
        }
    }
    
    public String getForumIntro(int i){
        if(i==0){
            return bulletinBoard.get("General").getIntroduction();
        }else{
            return bulletinBoard.get("Official").getIntroduction();
        }
    }
    
    public List<String> getForumCategory(int i){
        if(i==0){
            return bulletinBoard.get("General").getCategory();
        }else {
            return bulletinBoard.get("Official").getCategory();
        }
    }
}