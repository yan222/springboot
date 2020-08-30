package cn.edu.ctbu.firstdata.controller;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("list")
    public String list(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
      //  IsLogin(httpServletRequest, httpServletResponse);
        return "student/list";
    }
    @GetMapping("add")
    public  String add(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws IOException{
     //   IsLogin(httpServletRequest, httpServletResponse);
        return "student/add";
    }
    @GetMapping("edit/{id}")
    public  String edit(@PathVariable Integer id,
                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException{
      //  IsLogin(httpServletRequest, httpServletResponse);
        return "student/edit";
    }

    @GetMapping("upload/{id}")
    public String upload(@PathVariable Integer id){
        return "student/upload";

    }

/*    private void IsLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException{
        HttpSession httpSession=httpServletRequest.getSession();
        String userName=(String)httpSession.getAttribute("username");
        if(userName==null||userName==""){
            //没有用户，用户没有登录
            httpServletResponse.sendRedirect("/login/student");
        }

    }*/


}
