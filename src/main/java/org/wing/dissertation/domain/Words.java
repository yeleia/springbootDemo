package org.wing.dissertation.domain;

import java.util.Date;

public class Words {
    private Integer id;

    private Integer studentid;

    private Integer menitorid;

    private String content;

    private Date wirtetime;

    public Words(Integer id, Integer studentid, Integer menitorid, String content, Date wirtetime) {
        this.id = id;
        this.studentid = studentid;
        this.menitorid = menitorid;
        this.content = content;
        this.wirtetime = wirtetime;
    }

    public Words() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getMenitorid() {
        return menitorid;
    }

    public void setMenitorid(Integer menitorid) {
        this.menitorid = menitorid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getWirtetime() {
        return wirtetime;
    }

    public void setWirtetime(Date wirtetime) {
        this.wirtetime = wirtetime;
    }
}