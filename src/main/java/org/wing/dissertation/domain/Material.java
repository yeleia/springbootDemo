package org.wing.dissertation.domain;

import java.util.Date;

public class Material {
    private Integer id;

    private Integer menitorid;

    private String title;

    private String describle;

    private String filepath;

    private String pdfpath;

    private String originname;

    private Date uploadtime;

    public Material(Integer id, Integer menitorid, String title, String describle, String filepath, String pdfpath, String originname, Date uploadtime) {
        this.id = id;
        this.menitorid = menitorid;
        this.title = title;
        this.describle = describle;
        this.filepath = filepath;
        this.pdfpath = pdfpath;
        this.originname = originname;
        this.uploadtime = uploadtime;
    }

    public Material() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenitorid() {
        return menitorid;
    }

    public void setMenitorid(Integer menitorid) {
        this.menitorid = menitorid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle == null ? null : describle.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getPdfpath() {
        return pdfpath;
    }

    public void setPdfpath(String pdfpath) {
        this.pdfpath = pdfpath == null ? null : pdfpath.trim();
    }

    public String getOriginname() {
        return originname;
    }

    public void setOriginname(String originname) {
        this.originname = originname == null ? null : originname.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
}