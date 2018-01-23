package org.wing.dissertation.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wing.dissertation.dao.ProjectMapper;
import org.wing.dissertation.domain.*;
import org.wing.dissertation.service.*;
import org.wing.dissertation.utils.MyDES;
import org.wing.dissertation.utils.Return;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Controller
/*
@RequestMapping("")
*/
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private MenitorService menitorService;
    @Autowired
    private MaterialService materialService;
    @RequestMapping("/addStudent")
    public void addStudent(StudentInfo studentInfo, HttpServletResponse response)throws Exception {
        Menitor menitor = (Menitor) SecurityUtils.getSubject().getPrincipal();
        if (menitor == null) {
            Return.resp(response,"未登录去登录","/dissertation/index");
        } else {
            studentInfo.setMenitorid(menitor.getId());
            int i = studentService.addStudent(studentInfo);
            if (i == 0) {
                Return.resp(response, "添加成功", "/dissertation/toAddStudent");
            } else {
                Return.resp(response, "该帐号已经存在", "/dissertation/toAddStudent");
            }
        }
    }
    @RequestMapping("/student/ajaxLogin")
    @ResponseBody
    public Map<String, Object> studentLogin(StudentInfo studentInfo, HttpServletRequest request){
        System.out.println("登录");
        Map<String, Object> resultMap = new LinkedHashMap<>();
        StudentInfo studentInfo1=studentService.login(studentInfo.getStudentlogin());
        System.out.println(studentInfo1.toString());
        if (studentInfo!=null){
            if (studentInfo.getLoginpass().equals(MyDES.decryptBasedDes(studentInfo1.getLoginpass()))){
                resultMap.put("status",200);
                resultMap.put("message","登录成功");
                request.getSession().setAttribute("studentInfo",studentInfo1);
            }else {
                resultMap.put("status",500);
                resultMap.put("message","请输入正确的密码");
            }
        }else {
            resultMap.put("status",404);
            resultMap.put("message","该用户不存在");
        }
        return resultMap;
    }
    @RequestMapping("/student/toChoseProject")
    public ModelAndView toChoseProject(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        if (studentInfo!=null){
           // System.out.println(studentInfo.getProjectId());
            List<Project> projectList=studentService.seeAllProject(studentInfo.getMenitorid());
            Project project=studentService.seeMyProject(studentInfo.getProjectId());
            if (project!=null) {
                if (project.getStatus() == 0) {
                    project = null;
                }
            }
            System.out.println(project);
            modelAndView.addObject("myProject",project);
            modelAndView.addObject("project",projectList);
            modelAndView.setViewName("student/choseProject");

        }else{
            modelAndView.setViewName("redirect:/dissertation/toStudentLogin");
        }
        return modelAndView;
    }
    @RequestMapping("/student/choseProject")
    @ResponseBody
    public Map<String,Object> choseProject(@RequestParam("id")Integer id,HttpServletRequest request){
        //System.out.println(id);
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        Map<String, Object> resultMap = new LinkedHashMap<>();
        if (studentInfo!=null){
            StudentInfo studentInfo1=studentService.selectByStudentId(studentInfo.getId());
            if (studentInfo1.getProjectId()==null){
                studentInfo.setProjectId(id);
                studentService.studentAddPro(studentInfo);
                projectService.updateStatus(id);
                Project project=projectService.down(id);
               // System.out.println(project+"yltest");
                resultMap.put("status",200);
                resultMap.put("project",project);
                resultMap.put("message","添加成功");
            }else {
                resultMap.put("status",500);
                resultMap.put("message","你已经选择了课题");
            }
        }else {
            resultMap.put("status",404);
            resultMap.put("message","登录超时");
        }
        return resultMap;
    }
    @RequestMapping("/student/deleteMyProject")
    public String  deleteMyProject(@RequestParam("id")Integer id,HttpServletRequest request){
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        Map<String, Object> resultMap = new LinkedHashMap<>();
        if (studentInfo!=null){
            studentService.studentDelePro(studentInfo.getId());
            projectService.updateStatus0(id);
           // System.out.println("successful");
            return "redirect:/dissertation/student/toChoseProject";
        }else {
            return "redirect:/dissertation/toStudentLogin";
        }
    }
    @RequestMapping("/student/myPaper")
    public ModelAndView  MyPaper(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        if (studentInfo!=null){
            Paper paper=paperService.seeMyPaper(studentInfo.getId());
            modelAndView.addObject("paper",paper);
            modelAndView.addObject("student/myPaper");
        }else {
            modelAndView.setViewName("redirect:/dissertation/toStudentLogin");
        }
       return modelAndView;
    }
    @RequestMapping("/student/seeMyMenitor")
    public ModelAndView myMenitor(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        if (studentInfo!=null){
            Menitor menitor=menitorService.seeMenitorInfo(studentInfo.getMenitorid());
            modelAndView.addObject("myMenitor",menitor);
            modelAndView.setViewName("student/myMenitor");
        }else {
            modelAndView.setViewName("redirect:/dissertation/toStudentLogin");
        }

        return modelAndView;
    }
    @RequestMapping("/student/seeMaterial")
    public ModelAndView seeMaterial(HttpServletRequest request){
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        ModelAndView modelAndView=new ModelAndView();
        if (studentInfo!=null){
            List<Material> materialList=materialService.showAllMaterial(studentInfo.getMenitorid());
            modelAndView.addObject("material",materialList);
            modelAndView.setViewName("student/showAllMaterial");
        }else {
            modelAndView.setViewName("redirect:/dissertation/toStudentLogin");
        }
        return modelAndView;
    }
    @RequestMapping("/student/seeMyMessage")
    public ModelAndView seeMyMessage(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        if (studentInfo!=null){
            StudentInfo studentInfo1=studentService.selectByStudentId(studentInfo.getId());
            studentInfo1.setLoginpass(MyDES.decryptBasedDes(studentInfo1.getLoginpass()));
            modelAndView.addObject("student",studentInfo1);
            modelAndView.setViewName("student/studentInfo");
        }else{
            modelAndView.setViewName("redirect:/dissertation/toStudentLogin");
        }
        return modelAndView;
    }
    @RequestMapping("/student/updateImage")
    @ResponseBody
    public Map<String,Object>updateImage(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request) throws IOException {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        if (studentInfo!=null){
            String fileName=file.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (prefix.equals("jpg")||prefix.equals("png")||prefix.equals("JPG")||prefix.equals("PNG")){
                String path = String.valueOf(ResourceUtils.getFile("classpath:static/uploadImage/"));
                String imageName= String.valueOf(Calendar.getInstance().getTimeInMillis());
                File targetFile=new File(path,imageName+"."+prefix);
                file.transferTo(targetFile);
                studentInfo.setStudentImage(imageName+"."+prefix);
                studentService.updateImage(studentInfo);
                resultMap.put("student",studentInfo);
                resultMap.put("status",200);

            }else {
                resultMap.put("status",500);
                resultMap.put("message","请上传jpg和png格式的图片");
            }
        }else {
            resultMap.put("status",404);
        }

        return resultMap;
    }
    @RequestMapping("/student/updateInfo")
    @ResponseBody
    public Map<String,Object> updateInfo(StudentInfo studentInfo,HttpServletRequest request){
        StudentInfo studentInfo1= (StudentInfo) request.getSession().getAttribute("studentInfo");
        Map<String, Object> resultMap = new LinkedHashMap<>();
        studentInfo.setLoginpass(MyDES.encryptBasedDes(studentInfo.getLoginpass()));
        if (studentInfo1!=null){
            studentService.updateInfo(studentInfo);
            resultMap.put("status",200);
        }else{
            resultMap.put("status",500);
        }

        return resultMap;
    }
    @RequestMapping("/student/outlogin")
    public String outlogin(HttpServletRequest request){
        request.getSession(false);
        return "redirect:/dissertation/toStudentLogin";
    }
    @RequestMapping("/student/uploadPaper")
    public void uploadPaper(@RequestParam(value = "file", required = false) MultipartFile file,Paper paper,HttpServletRequest request,HttpServletResponse response) throws Exception {
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        if (studentInfo!=null){
            StudentInfo studentInfo1=studentService.selectByStudentId(studentInfo.getId());
            if (studentInfo1.getProjectId()!=null){
                String fileName = file.getOriginalFilename();
                String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (prefix.equals("pdf")||prefix.equals("PDF")){
                    String path = String.valueOf(ResourceUtils.getFile("classpath:static/upload/"));
                    String imageName= String.valueOf(Calendar.getInstance().getTimeInMillis());
                    File targetFile=new File(path,imageName+"."+prefix);
                    file.transferTo(targetFile);
                    paper.setPaper(imageName+"."+prefix);
                    paper.setStudentId(studentInfo.getId());
                    paper.setProjectid(studentInfo.getProjectId());
                    paper.setUploadtime(new Date());
                    Paper paper1=paperService.seeMyPaper(studentInfo.getId());
                    System.out.println(paper1);
                    if (paper1!=null){
                        System.out.println("test++++");
                        History history=new History();
                        history.setPaper(paper.getPaper());
                        history.setPaperid(paper1.getProjectid());
                        history.setPloadtime(paper1.getUploadtime());
                        history.setPstatus(paper1.getPstatus());
                        historyService.insertHistory(history);
                    }
                    paperService.insertPaper(paper);
                    Return.resp(response,"上传成功","/dissertation/student/myPaper");
                }else {
                    Return.resp(response,"请上传pdf文档","/dissertation/student/myPaper");
                }
            }else {
                    Return.resp(response,"你未选择课题","/dissertation/student/myPaper");
            }
        }else {
            Return.resp(response,"登录超时","/dissertation/toStudentLogin");
        }
    }
    @RequestMapping("/student/loadPa")
    public ResponseEntity<byte[]> loadPa(@RequestParam("id")Integer id) throws Exception {
        Paper paper=paperService.selectById(id);
        Project project=projectService.down(paper.getProjectid());
        String filePath = String.valueOf(ResourceUtils.getFile("classpath:static/upload/")+"/"+paper.getPaper());
        File file=new File(filePath);
        HttpHeaders headers=new HttpHeaders();
        String fileName = new String(project.getTitle().getBytes("UTF-8"), "iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
    @RequestMapping("/student/myhistory")
    public ModelAndView history(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        StudentInfo studentInfo= (StudentInfo) request.getSession().getAttribute("studentInfo");
        if (studentInfo!=null){
            List<History> historyList=historyService.seeHistory(studentInfo.getProjectId());
           // System.out.println(historyList.size()+"testlll");
            modelAndView.addObject("history",historyList);
            modelAndView.setViewName("student/myHistory");
        }
        return modelAndView;
    }
}
