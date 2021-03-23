/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author WarSpite
 */
public class LolOfficialPostList implements Sortable, PostList{
    private List<Post> officialPostList = new ArrayList<>();
    private UserList userList = new UserList();
    private Calendar calendar = new GregorianCalendar();
    private static final LolAvailableCategory avaCategory = new LolAvailableCategory();
    private List <String>officialCategory = avaCategory.getAvailableOfficialCategorys();
    private String icon = "/image/forumImages/lolOfficial.jpg";
    private String introduction = "the League of Legends Official~";
    
    public LolOfficialPostList() {
        addSomePost();
    }

    private void addSomePost(){
        //String title, String decription, Date date, User user, int postNumber
        //year, month, dayOfMonth, hourOfDay, minute, second
        
        calendar = new GregorianCalendar(1999,4,29,18,30,30);//tester,I hope it will work
        Post post = new Post("official Tester 1 Title","Hello, this is the first official post",calendar,userList.get(0),0,new PostCategory(officialCategory.get(0)),"Official");
        post.setPostView(100);
        ArrayList<Reply> testReply = new ArrayList<>();
        //User respondent, Calendar calendar, String replyText
        Reply reply = new Reply(userList.get(0), new GregorianCalendar(2018,1,1,1,1,1),"Test reply function");
        testReply.add(reply);
        post.setPostView(300);
        post.setReplys(testReply);
        post.setNewestEdit(testReply.get(testReply.size()-1).getDate());
        officialPostList.add(post);
        
        calendar = new GregorianCalendar(1999,4,29,18,30,30);//tester,I hope it will work
        post = new Post("general Tester 12 Title","general Tester 12 Decription",calendar,userList.get(1),officialPostList.size(),new PostCategory(officialCategory.get(1)),"Official");
        post.setPostView(100);
        officialPostList.add(post);
        
        calendar = new GregorianCalendar(2009,2,2,12,15,22);
        post = new Post("general Tester 2 Title","general Tester 2 Decription",calendar,userList.get(2),officialPostList.size(),new PostCategory(officialCategory.get(2)),"Official");
        post.setPostView(200);
        officialPostList.add(post);
        
        calendar = new GregorianCalendar(2013,2,2,12,15,22);
        post = new Post("general Tester 4 Title","general Tester 4 Decription",calendar,userList.get(2),officialPostList.size(),new PostCategory(officialCategory.get(2)),"Official");
        post.setPostView(200);
        officialPostList.add(post);
    }
    

    
    @Override
    public void add(Post post) {
        officialPostList.add(post);
    }
    @Override
    public void removePost(int index){
        this.officialPostList.remove(index);
    }
    
    @Override
    public int size() {
        return officialPostList.size();
    }
    @Override
    public boolean isEmpty() {
        return officialPostList.isEmpty();
    }
    @Override
    public Post get(int index) {
        return officialPostList.get(index);
    }
    
    @Override
    public void printList() {
        officialPostList.forEach((d) -> {
            System.out.println(d.getUser().getUserName() + "\n" + d.getTitle()+"\n"+d.getDecription());
        });
    }

    @Override
    public List<Post> getPostList() {
        return officialPostList;
    }

    public void setPostList(ArrayList<Post> postList) {
        this.officialPostList = postList;
    }

    private final Comparator <Post>newestEdit = (Comparator<Post>) (Post p1, Post p2) -> {
        if (p1.getNewestEdit().after(p2.getNewestEdit())) {
            return -1;
        } else if (p1.getNewestEdit()== p2.getNewestEdit()) {
            return 0;
        } else {
            return 1;
        }
    };
    
    @Override
    public List<Post> getSortedPostList() {
        return officialPostList;
    }

    public void setSortedPostList(List<Post> sortedGeneralPostList) {
        this.officialPostList = sortedGeneralPostList;
    }


    @Override
    public void setPostList(List<Post> generalPostList) {
        this.officialPostList = generalPostList;
    }

    @Override
    public void sortByNewestUpdate() {
        Collections.sort(officialPostList, newestEdit);
    }

    @Override
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public List<String> getCategory() {
        return officialCategory;
    }

    public void setOfficialCategory(List<String> officialCategory) {
        this.officialCategory = officialCategory;
    }
    
    

}
