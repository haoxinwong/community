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
public class LolGeneralPostList implements Sortable, PostList {

    private List<Post> generalPostList = new ArrayList<>();
    private UserList userList = new UserList();
    private Calendar calendar = new GregorianCalendar();
    private static final LolAvailableCategory avaCategory = new LolAvailableCategory();
    private List<String> generalCategory = avaCategory.getAvailableGeneralCategorys();
    private String icon = "/image/forumImages/lolGeneral.jpg";
    private String introduction = "Toss a coin to the witcher~";

    public LolGeneralPostList() {
        addSomePost();
    }

    private void addSomePost() {
        //String title, String decription, Date date, User user, int postNumber
        //year, month, dayOfMonth, hourOfDay, minute, second
        calendar = new GregorianCalendar(2015, 4, 29, 18, 30, 30);//tester,I hope it will work
        String weTheWorld = "There comes a time\n"
                + "When we heed a certain call\n"
                + "When the world must come together as one\n"
                + "There are people dying\n"
                + "Oh, and it's time to lend a hand to life\n"
                + "The greatest gift of all\n"
                + "We can't go on\n"
                + "Pretending day-by-day\n"
                + "That someone, somewhere soon make a change\n"
                + "We're all a part of God's great big family\n"
                + "And the truth, you know, love is all we need\n"
                + "We are the world\n"
                + "We are the children\n"
                + "We are the ones who make a brighter day, so let's start giving\n"
                + "There's a choice we're making\n"
                + "We're saving our own lives\n"
                + "It's true we'll make a better day, just you and me\n"
                + "Oh, send them your heart\n"
                + "So they know that someone cares\n"
                + "And their lives will be stronger and free\n"
                + "As God has shown us by turning stones to bread\n"
                + "And so we all must lend a helping hand\n"
                + "We are the world\n"
                + "We are the children\n"
                + "We are the ones who make a brighter day, so let's start giving\n"
                + "Oh, there's a choice we're making\n"
                + "We're saving our own lives\n"
                + "It's true we'll make a better day, just you and me\n"
                + "When you're down and out, there seems no hope at all\n"
                + "But if you just believe there's no way we can fall\n"
                + "Well, well, well, well let us realize\n"
                + "Oh, that a change can only come\n"
                + "When we stand together as one, yeah, yeah, yeah\n"
                + "We are the world\n"
                + "We are the children\n"
                + "We are the ones who make a brighter day, so let's start giving\n"
                + "There's a choice we're making\n"
                + "We're saving our own lives\n"
                + "It's true we'll make a better day, just you and me\n"
                + "We are the world\n"
                + "We are the children\n"
                + "We are the ones who make a brighter day, so let's start giving\n"
                + "There's a choice we're making\n"
                + "We're saving our own lives\n"
                + "It's true we'll make a better day, just you and me";
        Post post = new Post("We Are The World", weTheWorld, calendar, userList.get(0), 0, new PostCategory(generalCategory.get(0), generalCategory.get(1)), "General");
        post.setPostView(100);
        List<Reply> testReplyFallen = new ArrayList<>();
        Reply tester = new Reply(userList.get(0), new GregorianCalendar(2018, 1, 1, 1, 1, 1), "HHHHHHHHHHHHHHHHHHHHHHHHHHHHello WWWWWWWWWWWWWWWWWWWWWWWWWorld! (autowrap text test)");
        testReplyFallen.add(tester);
        String FallenAngel = "Heaven, please sing for me a song of life\n"
                + "Heaven, save me in my dreams tonight\n"
                + "Someday these wings will perish in your side\n"
                + "Night and day I call for you\n"
                + "Flashes of moments of tragic\n"
                + "Wandering souls, they fell along the way\n"
                + "Tell me you will never leave me... forever and ever\n"
                + "I gotta be, I gotta be, in your arms, hear me\n"
                + "You're so close, so close\n"
                + "And its you I believe in I believe in\n"
                + "So close but faraway, I seek for your light\n"
                + "I'll hold on\n"
                + "Cuz for you my hearts keep beating\n"
                + "When the wind, the fire and all is gone\n"
                + "Caress me with your sweet lullaby\n"
                + "Will you be my light\n"
                + "Will you be my strength\n"
                + "Promise you won't let go.\n"
                + "I'll never betray\n"
                + "(And) in the end of time\n"
                + "Still my love's gonna be there\n"
                + "You're so close, so close\n"
                + "And its you I believe in I believe in\n"
                + "So close but faraway, I seek for your light\n"
                + "I'll hold on\n"
                + "Cuz for you my hearts keep beating\n"
                + "When the wind, the fire and all is gone\n"
                + "Caress me with your sweet lullaby";
        Reply replyFallen = new Reply(userList.get(0), new GregorianCalendar(2019, 1, 1, 1, 1, 1), FallenAngel);
        testReplyFallen.add(replyFallen);
        post.setReplys(testReplyFallen);
        post.setNewestEdit(testReplyFallen.get(testReplyFallen.size() - 1).getDate());
        generalPostList.add(post);

        calendar = new GregorianCalendar(2009, 2, 2, 12, 15, 22);
        post = new Post("general Tester 2 Title", "general Tester 2 Decription", calendar, userList.get(1), generalPostList.size(), new PostCategory(generalCategory.get(0)), "General");
        post.setPostView(200);
        generalPostList.add(post);

        calendar = new GregorianCalendar(1999, 11, 9, 7, 4, 38);
        post = new Post("general Tester 3 Title", "general Tester 3 Decription", calendar, userList.get(2), generalPostList.size(), "General");
        List<Reply> testReply = new ArrayList<>();
        //User respondent, Calendar calendar, String replyText
        Reply reply = new Reply(userList.get(0), new GregorianCalendar(2018, 1, 1, 1, 1, 1), "Test reply function1");
        testReply.add(reply);
        reply = new Reply(userList.get(0), new GregorianCalendar(2018, 1, 1, 1, 1, 1), "Test reply function2");
        testReply.add(reply);
        post.setPostView(300);
        post.setReplys(testReply);
        post.setNewestEdit(testReply.get(testReply.size() - 1).getDate());
        generalPostList.add(post);
        sortByNewestUpdate();
    }

    @Override
    public void add(Post post) {
        generalPostList.add(post);
    }

    @Override
    public void removePost(int index) {
        this.generalPostList.remove(index);
    }

    @Override
    public int size() {
        return generalPostList.size();
    }

    @Override
    public boolean isEmpty() {
        return generalPostList.isEmpty();
    }

    @Override
    public Post get(int index) {
        return generalPostList.get(index);
    }

    @Override
    public void printList() {
        generalPostList.forEach((d) -> {
            System.out.println(d.getUser().getUserName() + "\n" + d.getTitle() + "\n" + d.getDecription());
        });
    }

    private Comparator<Post> newestEdit = (Comparator<Post>) (Post p1, Post p2) -> {
        if (p1.getNewestEdit().after(p2.getNewestEdit())) {
            return -1;
        } else if (p1.getNewestEdit() == p2.getNewestEdit()) {
            return 0;
        } else {
            return 1;
        }
    };

    @Override
    public void sortByNewestUpdate() {
        Collections.sort(generalPostList, newestEdit);
    }

    @Override
    public List<Post> getPostList() {
        return generalPostList;
    }

    @Override
    public List<Post> getSortedPostList() {
        sortByNewestUpdate();
        return generalPostList;
    }

    @Override
    public void setPostList(List<Post> generalPostList) {
        this.generalPostList = generalPostList;
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
        return generalCategory;
    }

    public void setGeneralCategory(List<String> generalCategory) {
        this.generalCategory = generalCategory;
    }

}
