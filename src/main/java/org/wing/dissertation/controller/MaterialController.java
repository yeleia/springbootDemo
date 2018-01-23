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
import org.wing.dissertation.domain.Material;
import org.wing.dissertation.domain.Menitor;
import org.wing.dissertation.service.MaterialService;
import org.wing.dissertation.utils.AsposeUtil;
import org.wing.dissertation.utils.Return;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
/*@RequestMapping("")*/
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    @RequestMapping("/addMaterial")
    public void addMaterial(Material material, @RequestParam(value = "file",required = false)MultipartFile file, HttpServletResponse response)throws Exception{
        System.out.println(file);
        //可以上传压缩包
        Menitor menitor= (Menitor) SecurityUtils.getSubject().getPrincipal();
        if (menitor!=null){
            if (!(file.isEmpty())){
                String fileName=file.getOriginalFilename();
                String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (!(prefix.equals("pdf")||prefix.equals("doc")||prefix.equals("docx")||prefix.equals("zip")||prefix.equals("rar"))){
                    Return.resp(response,"请上传pdf,word文档或压缩包","/dissertation/toAddMaterial");
                }else if (file.getSize() > 10485760){
                    Return.resp(response,"请上传小于10M的文件","/dissertation/toAddMaterial");
                }else {
                    String path = String.valueOf(ResourceUtils.getFile("classpath:static/upload/"));
                    String name = String.valueOf(Calendar.getInstance().getTimeInMillis());
                    String filesName = name + "." + prefix;
                    File targetFile = new File(path, filesName);
                    file.transferTo(targetFile);
                    //将word文档转换为pdf
                    if (prefix.equals("doc")||prefix.equals("docx")){
                        String name1 = String.valueOf(Calendar.getInstance().getTimeInMillis());
                        AsposeUtil.docToPdf(path + "/" + filesName, path + "/" + name1 + ".pdf");
                        material.setPdfpath(name1+".pdf");
                    }else {
                        material.setPdfpath(filesName);
                    }
                    material.setFilepath(filesName);
                    material.setUploadtime(new Date());
                    material.setMenitorid(menitor.getId());
                    material.setOriginname(fileName);
                    materialService.addMaterial(material);
                    Return.resp(response,"添加成功","/dissertation/toAddMaterial");
                }
            }
        }else {
            Return.resp(response,"请登录","/dissertation/index");
        }
    }
    @RequestMapping("/showAll")
    public String showAllMaterial(Model model){
        Menitor menitor= (Menitor) SecurityUtils.getSubject().getPrincipal();
        if (menitor!=null){
            List<Material> materialList=materialService.showAllMaterial(menitor.getId());
            //找出压缩包
            for (int i=0;i<materialList.size();i++){

            }
            model.addAttribute("material",materialList);
            return "mentor/showAllMaterial";
        }else {
            return "redirect:/dissertation/index";
        }

    }
    @RequestMapping("/downMaterial")
    public ResponseEntity<byte[]> download(@RequestParam("id")Integer id) throws Exception {
        Material material=materialService.downMaterial(id);
        String filePath = String.valueOf(ResourceUtils.getFile("classpath:static/upload/")+"/"+material.getFilepath());
        File file=new File(filePath);
        HttpHeaders headers=new HttpHeaders();
        String fileName = new String(material.getOriginname().getBytes("UTF-8"), "iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
    @RequestMapping("/student/downMaterial")
    public ResponseEntity<byte[]> download1(@RequestParam("id")Integer id) throws Exception {
        Material material=materialService.downMaterial(id);
        String filePath = String.valueOf(ResourceUtils.getFile("classpath:static/upload/")+"/"+material.getFilepath());
        File file=new File(filePath);
        HttpHeaders headers=new HttpHeaders();
        String fileName = new String(material.getOriginname().getBytes("UTF-8"), "iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
    @RequestMapping("/updateMaterial")
    public void updateMaterial(Material material,@RequestParam(value = "file",required = false)MultipartFile file,HttpServletResponse response)throws Exception{
        Menitor menitor= (Menitor) SecurityUtils.getSubject().getPrincipal();
        //System.out.println(file);
        Material material1=materialService.downMaterial(material.getId());
        if (menitor!=null) {
            if (!(file.isEmpty())){
                String fileName=file.getOriginalFilename();
                String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
                if (!(prefix.equals("pdf")||prefix.equals("doc")||prefix.equals("docx"))){
                    Return.resp(response,"请上传word文档或pdf或压缩包","/dissertation/showAll");
                }else if (file.getSize()>10485760){
                    Return.resp(response,"请上传小于10M的文件","/dissertation/showAll");
                }else {
                    String path= String.valueOf(ResourceUtils.getFile("classpath:static/upload/"));
                    String name=null;
                    //从数据库查询是否存在文件名，存在就直接用之前的document
                    if (material1.getFilepath()!=null){
                        name=material1.getFilepath();
                    }else {
                        name= String.valueOf(Calendar.getInstance().getTimeInMillis());
                    }
                    String filesName=name;
                    File targetFile=new File(path,filesName);
                    file.transferTo(targetFile);
                    //将word转换为pdf,如果为pdf就不转换，文件名和document相同
                    String name1=null;
                    if (material1.getPdfpath()!=null){
                        if (prefix.equals("doc")||prefix.equals("docx")){
                            name1=material1.getPdfpath();
                            AsposeUtil.docToPdf(path+"/"+filesName,path+"/"+name1);
                        }else {
                            name1=name;
                        }
                    }else {
                        name1=String.valueOf(Calendar.getInstance().getTimeInMillis());
                    }
                    material.setPdfpath(name1+".pdf");
                    material.setFilepath(filesName);
                    material.setOriginname(fileName);
                }

            }else {
                material.setOriginname(material1.getOriginname());
                material.setFilepath(material1.getFilepath());
                material.setPdfpath(material1.getPdfpath());
                //material.setDescrible(material1.getDescrible());
            }
            material.setUploadtime(new Date());
           // System.out.println(material.getDescrible());
            materialService.updateMaterial(material);
            System.out.println("修改成功");
            Return.resp(response,"修改成功","/dissertation/showAll");
        }else {
            Return.resp(response,"请登录","/dissertation/index");
        }
    }
    @RequestMapping("/deleteMaterial")
    public void deleteMaterial(@RequestParam("id")Integer id,HttpServletResponse response)throws Exception{
        materialService.deleteMaterialById(id);
        Return.resp(response,"删除成功","/dissertation/showAll");
    }
}
