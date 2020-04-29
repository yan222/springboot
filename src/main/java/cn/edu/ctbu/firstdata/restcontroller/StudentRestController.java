package cn.edu.ctbu.firstdata.restcontroller;

import cn.edu.ctbu.firstdata.domain.Student;
import cn.edu.ctbu.firstdata.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/webapi/student")
public class StudentRestController {
    @Autowired
    IStudentService studentService;

    @GetMapping("list")
    public List<Student> GetAll(){
        return studentService.getAll();
    }
    @GetMapping(value="{id}")
    public Student GetById(@PathVariable Integer id){
        return studentService.findById(id);
    }
}
