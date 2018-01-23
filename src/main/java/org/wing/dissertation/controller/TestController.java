package org.wing.dissertation.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
/*
@RequestMapping("")
*/
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "mentor/login";
    }
    @RequestMapping("/test")
    public String test(){
        /*System.out.println("yyyyy");*/
        return "mentor/index";
    }
    @RequestMapping("/toStudentLogin")
    public String toStudentLogin(){
        return "student/login";
    }
    //仅测试
    @RequestMapping("/student/index")
    public String studentIndex(){
        return "student/studentIndex";
    }
    @RequestMapping("/toLoadPaper")
    public String toLoadPaper(){
        System.out.println("testP");
        return "student/onloadPaper";
    }
}
