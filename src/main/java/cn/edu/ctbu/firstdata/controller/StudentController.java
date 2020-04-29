package cn.edu.ctbu.firstdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("list")
    public String list(){
        return "student/list";
    }
}
