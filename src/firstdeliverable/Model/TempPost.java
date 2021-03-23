/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

/**
 *
 * @author WarSpite
 */
public class TempPost {
    private String title;
    private String forum;
    private String description;

    public TempPost(String title, String forum, String description) {
        this.title = title;
        this.forum = forum;
        this.description = description;
    }

    public TempPost() {
    }

    
    public TempPost(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public TempPost(String str,int i) {
        if(i==0){
            this.title = str;
            this.description="";
        }else if(i==1){
            this.title = "";
            this.description = str;
        }
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
