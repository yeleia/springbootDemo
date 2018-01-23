package org.wing.dissertation.service;

import org.wing.dissertation.domain.Project;
import org.wing.dissertation.domain.StudentInfo;

import java.util.List;

public interface StudentService {
    int addStudent(StudentInfo studentInfo);
    StudentInfo login(String loginName);
    List<StudentInfo> seeStudentMessage(Integer id);
    List<Project> seeAllProject(Integer id);
    Project seeMyProject(Integer id);
    StudentInfo selectByStudentId(Integer id);
    Integer studentAddPro(StudentInfo studentInfo);
    Integer studentDelePro(Integer id);
    Integer updateImage(StudentInfo studentInfo);
    Integer updateInfo(StudentInfo studentInfo);
    Integer updateProject(Integer id);
}
