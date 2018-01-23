package org.wing.dissertation.controller;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.wing.dissertation.domain.Menitor;
import org.wing.dissertation.domain.Project;
import org.wing.dissertation.service.ProjectService;
import org.wing.dissertation.service.StudentService;
import org.wing.dissertation.utils.AsposeUtil;
import org.wing.dissertation.utils.Return;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
/*
@RequestMapping("")
*/
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private StudentService studentService;
    @RequestMapping("/seeProject")
    public String seeProject(Model model) throws Exception {
        Menitor menitor = (Menitor) SecurityUtils.getSubject().getPrincipal();
        if (menitor!=null) {
            List<Project> projectList = projectService.selectAll(menitor.getId());
            model.addAttribute("project", projectList);
            return "mentor/crud";
        }else {
            return "redirect:/dissertation/index";
        }
    }
    @RequestMapping("/addProject")
    public void addProject(Project project, @RequestParam(value = "file" ,required = false) MultipartFile file, HttpServletResponse response)throws Exception {
        Menitor menitor = (Menitor) SecurityUtils.getSubject().getPrincipal();
        if (menitor!=null) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                //System.out.println(prefix);
                if (!(prefix.equals("pdf")/*||prefix.equals("txt")||prefix.equals("excel")*/ || prefix.equals("doc") || prefix.equals("docx"))) {
                    Return.resp(response, "请上传word文档或pdf", "/dissertation/seeProject");
                } else if (file.getSize() > 10485760) {
                    Return.resp(response, "请上传小于10M的文件", "/dissertation/seeProject");
                } else {
                    String path = String.valueOf(ResourceUtils.getFile("classpath:static/upload/"));
                    //String path = request.getSession().getServletContext().getRealPath("upload/");
                   // System.out.println(path);
                    String name = String.valueOf(Calendar.getInstance().getTimeInMillis());
                    String filesName = name + "." + prefix;
                    File targetFile = new File(path, filesName);
                    file.transferTo(targetFile);
                    //将word文档转化为pdf
                    if (!(prefix.equals("pdf"))) {
                        String name1 = String.valueOf(Calendar.getInstance().getTimeInMillis());
                        AsposeUtil.docToPdf(path + "/" + filesName, path + "/" + name1 + ".pdf");
                        project.setDocumentpdf(name1+".pdf");
                    }else {
                        project.setDocumentpdf(filesName);
                    }
                    project.setTeacherid(menitor.getId());
                    project.setPublishtime(new Date());
                    project.setDocument(filesName);
                    project.setOriginame(fileName);
                    projectService.addProject(project);
                    Return.resp(response, "添加课题成功", "/dissertation/seeProject");
                }
            } /*else {
                Return.resp(response, "你未上传文档哦", "/seeProject");
            }*/
        }else {
            Return.resp(response,"请登录","/index");
        }
    }
    @RequestMapping("/down")
    public ResponseEntity<byte[]>  download(@RequestParam("id")Integer id) throws Exception {
        Project project=projectService.down(id);
        String filePath = String.valueOf(ResourceUtils.getFile("classpath:static/upload/")+"/"+project.getDocument());
        File file=new File(filePath);
        HttpHeaders headers=new HttpHeaders();
        String fileName = new String(project.getOriginame().getBytes("UTF-8"), "iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
    @RequestMapping("/student/down")
    public ResponseEntity<byte[]>  studownload(@RequestParam("id")Integer id) throws Exception {
        Project project=projectService.down(id);
        String filePath = String.valueOf(ResourceUtils.getFile("classpath:static/upload/")+"/"+project.getDocument());
        File file=new File(filePath);
        HttpHeaders headers=new HttpHeaders();
        String fileName = new String(project.getOriginame().getBytes("UTF-8"), "iso-8859-1");
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
    @RequestMapping("/updateProject")
    public void updateP(Project project,@RequestParam(value = "file",required = false)MultipartFile file,HttpServletResponse response)throws Exception{
        Menitor menitor= (Menitor) SecurityUtils.getSubject().getPrincipal();
        System.out.println(menitor.getId()+"update");
        Project project1=projectService.down(project.getId());
        if (menitor!=null) {
            if (!(file.isEmpty())){
                String fileName=file.getOriginalFilename();
                String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
                if (!(prefix.equals("pdf")||prefix.equals("doc")||prefix.equals("docx"))){
                    Return.resp(response,"请上传word文档或pdf","/dissertation/seeProject");
                }else if (file.getSize()>10485760){
                    Return.resp(response,"请上传小于10M的文件","/dissertation/seeProject");
                }else {
                    String path= String.valueOf(ResourceUtils.getFile("classpath:static/upload/"));
                    String name=null;
                    //从数据库查询是否存在文件名，存在就直接用之前的document
                    if (project1.getDocument()!=null){
                        name=project1.getDocument();
                    }else {
                        name= String.valueOf(Calendar.getInstance().getTimeInMillis());
                    }
                    String filesName=name;
                    File targetFile=new File(path,filesName);
                    file.transferTo(targetFile);
                    //将word转换为pdf,如果为pdf就不转换，文件名和document相同
                    String name1=null;
                    if (project1.getDocumentpdf()!=null){
                        if (!(prefix.equals("pdf"))){
                            name1=project1.getDocumentpdf();
                            AsposeUtil.docToPdf(path+"/"+filesName,path+"/"+name1);
                        }else {
                            name1=name;
                        }
                    }else {
                        name1=String.valueOf(Calendar.getInstance().getTimeInMillis());
                    }
                    project.setDocumentpdf(name1);
                    project.setDocument(filesName);
                    project.setOriginame(fileName);
                }
            }else {
                project.setOriginame(project1.getOriginame());
                project.setDocument(project1.getDocument());
                project.setDocumentpdf(project1.getDocumentpdf());
            }
            project.setPublishtime(new Date());
            projectService.updateById(project);
            System.out.println("修改成功");
            Return.resp(response,"修改成功","/dissertation/seeProject");
        }else {
            Return.resp(response,"请登录","/dissertation/index");
        }
    }
    @RequestMapping("/delete")
    public void deleteById(@RequestParam("id")Integer id,HttpServletResponse response) throws Exception {
        projectService.deleteById(id);
        studentService.updateProject(id);
        Return.resp(response,"删除成功","/dissertation/seeProject");
    }
}
