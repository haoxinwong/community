/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author WarSpite
 */
public class Post {
    private String title;
    private String decription;
    private Calendar calendar;
    private User user;
    private int postNumber;
    private List<Reply>replys = new ArrayList<>();
    private int postView;
    private int thumbsUp;
    private PostCategory postCategory;
    private Calendar newestEdit;
    private String forum;

    public Post() {
    }

    
    public Post(String title, String decription, Calendar calendar, User user, int postNumber,String forum) {
        this.title = title;
        this.decription = decription;
        this.calendar = calendar;
        this.user = user;
        this.postNumber = postNumber;
        this.postView = 0;
        this.thumbsUp = 0;
        this.postCategory = new PostCategory();
        this.newestEdit = calendar;
        this.forum = forum;
    }

    public Post(String title, String decription, Calendar calendar, User user, int postNumber, PostCategory postCategory,String forum) {
        this.title = title;
        this.decription = decription;
        this.calendar = calendar;
        this.user = user;
        this.postNumber = postNumber;
        this.postCategory = postCategory;
        this.postView = 0;
        this.thumbsUp = 0;
        this.newestEdit = calendar;
        this.forum = forum;
    }

        
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Calendar getDate() {
        return calendar;
    }

    public void setDate(Calendar calendar) {
        this.calendar = calendar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public int getPostView() {
        return postView;
    }

    public void setPostView(int postView) {
        this.postView = postView;
    }

    public List<Reply> getReplys() {
        return replys;
    }

    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }
    
    public void addReply(Reply reply){
        replys.add(reply);
    }

    public int getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(int thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public Calendar getNewestEdit() {
        return newestEdit;
    }

    public void setNewestEdit(Calendar newestEdit) {
        this.newestEdit = newestEdit;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    
    @Override
    public String toString() {
        return "Post{" + "title=" + title + ", decription=" + decription + ", calendar=" + calendar + ", user=" + user + ", postNumber=" + postNumber + ", replys=" + replys + ", postView=" + postView + ", thumbsUp=" + thumbsUp + ", postCategory=" + postCategory + ", newestEdit=" + newestEdit + '}';
    }
    
    
}
