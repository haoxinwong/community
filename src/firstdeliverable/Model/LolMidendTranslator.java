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
public class LolMidendTranslator {

    private LolBulletinBoard lolBulletinBoard = new LolBulletinBoard();
    private PostList currentList = lolBulletinBoard.getGeneralPostList();
    private List<Post> showList;
    private int totalPostSize;
    private boolean isEnd = false;
    private String name;

    public LolMidendTranslator(int selection) {
        initialize();
        setTotalPostSize();
        name = lolBulletinBoard.getName();
    }

    public void Selector(int number) {
        if (number == 0) {
            currentList = lolBulletinBoard.getGeneralPostList();
        } else if (number == 1) {
            currentList = lolBulletinBoard.getOfficialPostList();
        }
    }

    public void createNewPost(Post post) {
        currentList.add(post);
    }

    public void addNewReply(int postNumber, Reply reply) {
        currentList.get(postNumber).getReplys().add(reply);
    }

    private void initialize() {
        showList = currentList.getSortedPostList();
    }

    public int showListSize() {
        return showList.size();
    }

    private void setTotalPostSize() {
        this.totalPostSize = showList.size();
    }

    public boolean isIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForumName(int i) {
        return lolBulletinBoard.getForumName(i);
    }

    public String getForumIcon(int i) {
        return lolBulletinBoard.getForumIcon(i);
    }

    public int getForumSize(int i) {
        return lolBulletinBoard.getForumSize(i);
    }

    public String getForumIntro(int i) {
        return lolBulletinBoard.getForumIntro(i);
    }

    public List<String> getForumCategory(int i) {
        return lolBulletinBoard.getForumCategory(i);
    }

    public int getTotalPostSize() {
        return totalPostSize;
    }

    public void setTotalPostSize(int totalPostSize) {
        this.totalPostSize = totalPostSize;
    }

    public List<Post> getShowList() {
        return showList;
    }

    public void setShowList(List<Post> showList) {
        this.showList = showList;
    }

    public List<Post> getAccessData(String forum) {
        if (forum.equals("General")) {
            return lolBulletinBoard.getGeneralList();
        } else {
            return lolBulletinBoard.getOfficialPostList().getPostList();
        }
    }

    public void refreshList(String forum) {
        if (forum.equals("General")) {
            lolBulletinBoard.getGeneralPostList().sortByNewestUpdate();
            currentList = lolBulletinBoard.getGeneralPostList();
            showList = lolBulletinBoard.getGeneralList();
        } else if (forum.equals("Official")) {
            lolBulletinBoard.getOfficialPostList().sortByNewestUpdate();
            currentList = lolBulletinBoard.getOfficialPostList();
            showList = lolBulletinBoard.getOfficialList();
        }
    }

    public LolBulletinBoard getLolBulletinBoard() {
        return lolBulletinBoard;
    }

    public void setLolBulletinBoard(LolBulletinBoard lolBulletinBoard) {
        this.lolBulletinBoard = lolBulletinBoard;
    }

    
}
