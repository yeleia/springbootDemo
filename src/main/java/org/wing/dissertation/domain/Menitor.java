package org.wing.dissertation.domain;

import java.util.Date;

public class Menitor {
    private Integer id;

    private String loginname;

    private String loginpass;

    private String menitorname;

    private String sex;

    private String campus;

    private String department;

    private String education;

    private String officephone;

    private String priovatephone;

    private String officeadress;

    private String qq;

    private String email;

    private String course;

    private String research;

    private String menitorimage;

    /*public Menitor(Integer id, String loginname, String loginpass, String menitorname, String sex, String campus, String department, String education, String officephone, String priovatephone, String officeadress, String qq, String email, String course, String research, String menitorimage) {
        this.id = id;
        this.loginname = loginname;
        this.loginpass = loginpass;
        this.menitorname = menitorname;
        this.sex = sex;
        this.campus = campus;
        this.department = department;
        this.education = education;
        this.officephone = officephone;
        this.priovatephone = priovatephone;
        this.officeadress = officeadress;
        this.qq = qq;
        this.email = email;
        this.course = course;
        this.research = research;
        this.menitorimage = menitorimage;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public String getMenitorname() {
        return menitorname;
    }

    public void setMenitorname(String menitorname) {
        this.menitorname = menitorname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone;
    }

    public String getPriovatephone() {
        return priovatephone;
    }

    public void setPriovatephone(String priovatephone) {
        this.priovatephone = priovatephone;
    }

    public String getOfficeadress() {
        return officeadress;
    }

    public void setOfficeadress(String officeadress) {
        this.officeadress = officeadress;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getMenitorimage() {
        return menitorimage;
    }

    public void setMenitorimage(String menitorimage) {
        this.menitorimage = menitorimage;
    }
}