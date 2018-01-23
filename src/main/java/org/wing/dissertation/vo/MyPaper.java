package org.wing.dissertation.vo;

import java.util.Date;

/**
 * Created by yeleia on 17-12-17.
 */
public class MyPaper {
    private String studentNum;
    private String studentName;
    private String studentProject;
    private String studentPaper;
    private Date paperTime;
    private Integer paperId;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Date getPaperTime() {
        return paperTime;
    }

    public void setPaperTime(Date paperTime) {
        this.paperTime = paperTime;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentProject() {
        return studentProject;
    }

    public void setStudentProject(String studentProject) {
        this.studentProject = studentProject;
    }

    public String getStudentPaper() {
        return studentPaper;
    }

    public void setStudentPaper(String studentPaper) {
        this.studentPaper = studentPaper;
    }
}
