/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

import java.util.List;

/**
 * 
 * @author WarSpite
 */
public interface PostList {
    void add(Post post);
    void removePost(int index);
    int size();
    boolean isEmpty();
    Post get(int index);
    void printList();
    List<Post> getSortedPostList();
    void setPostList(List<Post> postList);
    List<Post> getPostList();
    String getIcon();
    String getIntroduction();
    List<String> getCategory();
    void sortByNewestUpdate();
}
