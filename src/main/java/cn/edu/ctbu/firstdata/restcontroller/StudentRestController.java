package cn.edu.ctbu.firstdata.restcontroller;

import cn.edu.ctbu.firstdata.domain.Student;
import cn.edu.ctbu.firstdata.helper.FileHelper;
import cn.edu.ctbu.firstdata.helper.PageUtils;
import cn.edu.ctbu.firstdata.helper.R;
import cn.edu.ctbu.firstdata.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.internal.FilterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/webapi/student")
public class StudentRestController {
    @Autowired
    IStudentService studentService;

    @GetMapping("list")
    public PageUtils GetAll(Integer pageSize, Integer pageNum) {
        Pageable pageable= PageRequest.of(pageNum-1,pageSize);
        Page<Student> tempStudents=studentService.getAll(pageable);
        PageUtils pageUtils=new PageUtils(tempStudents.getTotalElements(),tempStudents.getContent());
        return pageUtils;
    }

    @GetMapping(value = "{id}")
    public R GetById(@PathVariable Integer id) {

        return R.ok("data",studentService.findById(id));
    }

    @PostMapping(value = "add")
    public R Add(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasGlobalErrors()){
            log.info(bindingResult.getFieldError().getDefaultMessage());
            return R.error(bindingResult.getFieldError().getDefaultMessage());

        }
        studentService.save(student);
        return R.ok("data",student);
    }

    @DeleteMapping(value = "delete/{id}")
    public boolean DeleteById(@PathVariable Integer id){
        studentService.delete(id);
        return true;
    }

    @DeleteMapping(value = "deletebyids")
    public boolean DeleteById( Integer ids[]){
        for(Integer i=0;i<ids.length;i++){
            studentService.delete(ids[i]);
        }

        return true;
    }
    @PostMapping(value = "update")
    public R update(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getFieldError().getDefaultMessage());
            return R.error(bindingResult.getFieldError().getDefaultMessage());
        }
        studentService.save(student);
        return R.ok("data",student);
    }

    @GetMapping(value = "login")
    public R login(String userName, String passWord, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        Student student=studentService.validUserNameAndPassword(userName,passWord);
        if(student!=null){
          HttpSession httpSession= httpServletRequest.getSession();
          httpSession.setAttribute("user",student);
        }

        return R.ok();
    }

    @PostMapping(value = "upload")
    public R upload(@RequestParam("file")MultipartFile file, @RequestParam("id")Integer id){
        Student student=studentService.findById(id);
        String url= FileHelper.saveFile(file);
        student.setAvatar(url);
        studentService.save(student);
        return R.ok();

    }
}

