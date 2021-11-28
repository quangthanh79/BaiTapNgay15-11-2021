package com.pqt.phamquangthanh.gmail;

import java.util.Date;

public class Inbox {
    private Date date;
    private String content;
    private String name_From;

    public Inbox(Date date, String content, String name_From) {
        this.date = date;
        this.content = content;
        this.name_From = name_From;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName_From() {
        return name_From;
    }

    public void setName_From(String name_From) {
        this.name_From = name_From;
    }
}
