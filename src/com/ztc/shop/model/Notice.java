package com.ztc.shop.model;

import java.sql.Timestamp;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/9.
 */
public class Notice {
    private int id;
    private String subject;
    private String content;
    private Timestamp date;
    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notice notice = (Notice) o;

        if (id != notice.id) return false;
        if (subject != null ? !subject.equals(notice.subject) : notice.subject != null) return false;
        if (content != null ? !content.equals(notice.content) : notice.content != null) return false;
        if (date != null ? !date.equals(notice.date) : notice.date != null) return false;
        if (account != null ? !account.equals(notice.account) : notice.account != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }
}
