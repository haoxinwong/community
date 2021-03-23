/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdeliverable.Model;

import java.util.Calendar;

/**
 *
 * @author WarSpite
 */
public class Reply {
    private User respondent;
    private Calendar calendar;
    private String replyText;

    public Reply(User respondent, Calendar calendar, String replyText) {
        this.respondent = respondent;
        this.calendar = calendar;
        this.replyText = replyText;
    }

    
    public User getRespondent() {
        return respondent;
    }

    public void setRespondent(User respondent) {
        this.respondent = respondent;
    }

    public Calendar getDate() {
        return calendar;
    }

    public void setDate(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }
    
    
}
