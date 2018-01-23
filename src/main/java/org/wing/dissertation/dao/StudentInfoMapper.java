package org.wing.dissertation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.wing.dissertation.domain.StudentInfo;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentInfoMapper {

    StudentInfo selectByLoginame(String studentLogin);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByMap(Map map);

    List<StudentInfo> selectByMenitorId(Integer id);

    StudentInfo selectByStudentId(Integer id);

    Integer addProject(StudentInfo studentInfo);

    Integer deletePro(Integer id);

    Integer updateImage(StudentInfo studentInfo);

    Integer updateInfo(StudentInfo studentInfo);

    Integer updateStudentPro(Integer id);

}