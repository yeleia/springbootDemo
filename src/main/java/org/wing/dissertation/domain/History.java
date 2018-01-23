package org.wing.dissertation.domain;

import java.util.Date;

public class History {
    private Integer id;

    private Integer paperid;

    private Date ploadtime;

    private String paper;

    private String pstatus;

    public History(Integer id, Integer paperid, Date ploadtime, String paper, String pstatus) {
        this.id = id;
        this.paperid = paperid;
        this.ploadtime = ploadtime;
        this.paper = paper;
        this.pstatus = pstatus;
    }

    public History() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Date getPloadtime() {
        return ploadtime;
    }

    public void setPloadtime(Date ploadtime) {
        this.ploadtime = ploadtime;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper == null ? null : paper.trim();
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus == null ? null : pstatus.trim();
    }
}