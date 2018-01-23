package org.wing.dissertation.service.serviceImpl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wing.dissertation.dao.ProjectMapper;
import org.wing.dissertation.dao.StudentInfoMapper;
import org.wing.dissertation.domain.Menitor;
import org.wing.dissertation.domain.Project;
import org.wing.dissertation.domain.StudentInfo;
import org.wing.dissertation.service.StudentService;
import org.wing.dissertation.utils.MyDES;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 添加学生，如果帐号存在，则返回1,不存在就添加并返回0
     * @param studentInfo
     * @return
     */
    @Override
    public int addStudent(StudentInfo studentInfo) {
        StudentInfo studentInfo1=studentInfoMapper.selectByLoginame(studentInfo.getStudentlogin());
        if (studentInfo1==null) {
            studentInfo.setStudentImage("222.jpg");
            studentInfo.setLoginpass(MyDES.encryptBasedDes(studentInfo.getLoginpass()));
            studentInfoMapper.insert(studentInfo);
            return 0;
        }else {
            return 1;
        }

    }

    /**
     * 学生登录
     * @param loginName
     * @return
     */
    @Override
    public StudentInfo login(String loginName) {
        System.out.println("login");
        StudentInfo studentInfo = studentInfoMapper.selectByLoginame(loginName);
        System.out.println(studentInfo.toString());
        return studentInfoMapper.selectByLoginame(loginName);
    }

    /**
     * 导师查看学生的信息
     * @param id
     * @return
     */
    @Override
    public List<StudentInfo> seeStudentMessage(Integer id) {
        return studentInfoMapper.selectByMenitorId(id);
    }

    /**
     * 学生查看所有的课题
     * @param id
     * @return
     */
    @Override
    public List<Project> seeAllProject(Integer id) {
        return projectMapper.selectAll(id);
    }

    /**
     * 学生查看自己的课题
     * @param id
     * @return
     */
    @Override
    public Project seeMyProject(Integer id) {
        return projectMapper.selectById(id);
    }

    /**
     * 根据id查看学生
     * @param id
     * @return
     */
    @Override
    public StudentInfo selectByStudentId(Integer id) {
        return studentInfoMapper.selectByStudentId(id);
    }

    /**
     * 学生添加课题
     * @param studentInfo
     * @return
     */
    @Override
    public Integer studentAddPro(StudentInfo studentInfo) {
        return studentInfoMapper.addProject(studentInfo);
    }

    /**\\
     *学生删除课题
     * @param id
     * @return
     */
    @Override
    public Integer studentDelePro(Integer id) {
        return studentInfoMapper.deletePro(id);
    }

    /**
     * 学生更改头像
     * @param studentInfo
     * @return
     */
    @Override
    public Integer updateImage(StudentInfo studentInfo) {
        return studentInfoMapper.updateImage(studentInfo);
    }

    /**
     * 学生修改信息
     * @param studentInfo
     * @return
     */
    @Override
    public Integer updateInfo(StudentInfo studentInfo) {
        return studentInfoMapper.updateInfo(studentInfo);
    }

    /**
     * 导师删除课题后，学生的直接设为null
     * @param id
     * @return
     */
    @Override
    public Integer updateProject(Integer id) {
        return studentInfoMapper.updateStudentPro(id);
    }
}
