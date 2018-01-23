package org.wing.dissertation.controller;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wing.dissertation.domain.Menitor;
import org.wing.dissertation.domain.Paper;
import org.wing.dissertation.domain.Project;
import org.wing.dissertation.domain.StudentInfo;
import org.wing.dissertation.service.MenitorService;
import org.wing.dissertation.service.PaperService;
import org.wing.dissertation.service.ProjectService;
import org.wing.dissertation.service.StudentService;
import org.wing.dissertation.utils.MyDES;
import org.wing.dissertation.vo.MyPaper;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
/*
@RequestMapping("")
*/
public class MenitorController {
    @Autowired
    private MenitorService menitorService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/menitor/ajaxLogin")
    @ResponseBody
    public Map<String, Object> ajaxLogin(@RequestParam("loginName") String loginName, @RequestParam("loginPass") String loginPass, HttpServletResponse response) {

        Map<String, Object> resultMap = new LinkedHashMap<>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPass);
            SecurityUtils.getSubject().login(token);
            //System.out.println(token);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        }
       /* System.out.println(resultMap.get("status"));
        System.out.println(resultMap.get("message"));*/
        return resultMap;
    }

    @RequestMapping("/toAddStudent")
    public String toAddStudent() {
        return "mentor/addStudent";
    }

    @RequestMapping("/toAddMaterial")
    public String toAddMaterial() {
        return "mentor/addMaterial";
    }

    @RequestMapping("/mentorInfo")
    public ModelAndView mentorInfo() {
        Menitor menitor = (Menitor) SecurityUtils.getSubject().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        if (menitor == null) {
            modelAndView.setViewName("/index");
        } else {
            Menitor menitor1 = menitorService.seeMenitorInfo(menitor.getId());
            menitor1.setLoginpass(MyDES.decryptBasedDes(menitor1.getLoginpass()));
            modelAndView.addObject("menitor", menitor1);
            modelAndView.setViewName("mentor/mentorInfo");
        }
        return modelAndView;
    }

    @RequestMapping("/modifyInfo")
    @ResponseBody
    public Map<String, Object> modifyInfo(Menitor menitor) {
        //System.out.println("hhhh");
        Menitor menitor1 = (Menitor) SecurityUtils.getSubject().getPrincipal();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        menitor.setLoginpass(MyDES.encryptBasedDes(menitor.getLoginpass()));
        int i = menitorService.modifyInfo(menitor);
        //System.out.println(i + menitor.getLoginname());
        if (menitor1 != null) {
            if (i != 0) {
                resultMap.put("status", 200);
            } else {
                resultMap.put("status", 500);
            }
        } else {
            resultMap.put("status", 400);
        }
        return resultMap;
    }

    @RequestMapping("/loadMenitorImage")
    @ResponseBody
    public Map<String, Object> onloadImage(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        //System.out.println("test");
        Menitor menitor = (Menitor) SecurityUtils.getSubject().getPrincipal();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        if(menitor!=null){
            String fileName = file.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (prefix.equals("jpg")||prefix.equals("png")||prefix.equals("PNG")||prefix.equals("JPG")){
                String path = String.valueOf(ResourceUtils.getFile("classpath:static/uploadImage/"));
                String imageName= String.valueOf(Calendar.getInstance().getTimeInMillis());
                File targetFile=new File(path,imageName+"."+prefix);
                file.transferTo(targetFile);
                menitor.setMenitorimage(imageName+"."+prefix);
                int i=menitorService.updateImage(menitor);
                //System.out.println(i+menitor.getMenitorimage());
                resultMap.put("menitor",menitor);
                resultMap.put("status",200);
            }else {
                //格式不正确
                resultMap.put("status",500);
            }
        }else {
            resultMap.put("status", 400);
        }
        return resultMap;
    }
   /* @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
        return "redirect:/index";
    }*/
   @RequestMapping("/seeStudentMessage")
    public ModelAndView seeStudentMessage(){
       ModelAndView modelAndView=new ModelAndView();
       Menitor menitor = (Menitor) SecurityUtils.getSubject().getPrincipal();
        if (menitor!=null){
            List<StudentInfo> studentInfoList=studentService.seeStudentMessage(menitor.getId());
            modelAndView.addObject("student",studentInfoList);
            modelAndView.setViewName("mentor/studentMessage");
        }else {
            //未登录
            modelAndView.setViewName("redirect:/index");
        }

       return modelAndView;
   }
   @RequestMapping("/seeStudentInfo")
    public ModelAndView seeStudentInfo(@RequestParam("id")Integer id){
        ModelAndView modelAndView=new ModelAndView();
        Menitor menitor = (Menitor) SecurityUtils.getSubject().getPrincipal();
        if (menitor!=null){
            StudentInfo studentInfo=studentService.selectByStudentId(id);
            Project project=projectService.down(studentInfo.getProjectId());
            if (project!=null){
                modelAndView.addObject("project",project);
            }
            modelAndView.addObject("student",studentInfo);
            modelAndView.setViewName("mentor/showStudentInfo");
        }else {
            modelAndView.setViewName("redirect:/index");
        }

       return modelAndView;
   }
   @RequestMapping("/seePapers")
    public ModelAndView seePapers(HttpServletResponse response)throws Exception{
        ModelAndView modelAndView=new ModelAndView();
       Menitor menitor = (Menitor) SecurityUtils.getSubject().getPrincipal();
        if (menitor!=null){
            List<StudentInfo> studentInfos=studentService.seeStudentMessage(menitor.getId());
            List<MyPaper> myPaperList=new ArrayList<>();
            for (int i=0;i<studentInfos.size();i++){
                StudentInfo studentInfo=studentService.selectByStudentId(studentInfos.get(i).getId());
                Project project=projectService.down(studentInfo.getProjectId());
                Paper paper=paperService.seeMyPaper(studentInfo.getId());
                System.out.println(studentInfos.get(i).getId()+"test");
                if (paper!=null&& project!=null){
                    System.out.println("test");
                    MyPaper myPaper = new MyPaper();
                    myPaper.setStudentName(studentInfo.getStudentname());
                    myPaper.setStudentNum(studentInfo.getStudentlogin());
                    myPaper.setStudentProject(project.getTitle());
                    myPaper.setStudentPaper(paper.getPaper());
                    myPaper.setPaperTime(paper.getUploadtime());
                    myPaper.setPaperId(paper.getId());
                    myPaperList.add(myPaper);
                }
            }
            modelAndView.addObject("myPaperList",myPaperList);
            modelAndView.setViewName("mentor/seePapers");
        }else {
            modelAndView.setViewName("redirect:/index");
        }
       return modelAndView;
   }
   @RequestMapping("/downPaper")
   public ResponseEntity<byte[]> loadPa(@RequestParam("id")Integer id) throws Exception {
       paperService.updatePs(id);
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
}
