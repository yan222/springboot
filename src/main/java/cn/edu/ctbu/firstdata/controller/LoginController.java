package cn.edu.ctbu.firstdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
    /*学生登录页
    * @return
    * */
    @GetMapping("student")
    public String student(){
        return "/common/login.html";
    }
}
