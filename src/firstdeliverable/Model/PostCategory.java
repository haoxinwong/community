/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author WarSpite
 */
public class PostCategory {
    private List<String>categoryList = new ArrayList<>();

    public PostCategory() {
    }
    
    public PostCategory(String...category){
        addCategory(category);
    }
    
    private  void addCategory(String...category){
        categoryList.addAll(Arrays.asList(category));
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }
    
}
