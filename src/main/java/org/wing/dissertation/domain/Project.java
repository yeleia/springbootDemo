package org.wing.dissertation.domain;

import java.util.Date;

public class Project {
    private Integer id;

    private Integer teacherid;

    private String title;

    private Date publishtime;

    private String document;
    private String documentpdf;
    private String originame;
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getDocument() {
        return document;
    }

    public String getDocumentpdf() {
        return documentpdf;
    }

    public void setDocumentpdf(String documentpdf) {
        this.documentpdf = documentpdf;
    }

    public String getOriginame() {
        return originame;
    }

    public void setOriginame(String originame) {
        this.originame = originame;
    }

    public void setDocument(String document) {
        this.document = document == null ? null : document.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}