package com.example.demo_1.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class e_announcement {
    @Id//主键注解
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键值的生成机制
    private Integer announcementid;
    private String title;
    private String content;
    private String posttime;

    public Integer getAnnouncementid() {
        return announcementid;
    }

    public void setAnnouncementid(Integer announcementid) {
        this.announcementid = announcementid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }
}
