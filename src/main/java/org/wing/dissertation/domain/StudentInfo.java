package org.wing.dissertation.domain;

public class StudentInfo {
    private Integer id;

    private Integer menitorid;

    private String studentlogin;

    private String loginpass;

    private String studentname;

    private String sex;

    private String campus;

    private String departmentroom;

    private String major;

    private String qq;

    private String email;

    private String tele;

    private String studentImage;
    private Integer paperId;
    private Integer projectId;

    public StudentInfo() {
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

    public String getStudentlogin() {
        return studentlogin;
    }

    public void setStudentlogin(String studentlogin) {
        this.studentlogin = studentlogin == null ? null : studentlogin.trim();
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass == null ? null : loginpass.trim();
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus == null ? null : campus.trim();
    }

    public String getDepartmentroom() {
        return departmentroom;
    }

    public void setDepartmentroom(String departmentroom) {
        this.departmentroom = departmentroom == null ? null : departmentroom.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", menitorid=" + menitorid +
                ", studentlogin='" + studentlogin + '\'' +
                ", loginpass='" + loginpass + '\'' +
                ", studentname='" + studentname + '\'' +
                ", sex='" + sex + '\'' +
                ", campus='" + campus + '\'' +
                ", departmentroom='" + departmentroom + '\'' +
                ", major='" + major + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", tele='" + tele + '\'' +
                ", studentImage='" + studentImage + '\'' +
                ", paperId=" + paperId +
                ", projectId=" + projectId +
                '}';
    }
}