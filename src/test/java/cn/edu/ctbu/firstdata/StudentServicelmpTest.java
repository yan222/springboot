package cn.edu.ctbu.firstdata;


import cn.edu.ctbu.firstdata.domain.Student;
import cn.edu.ctbu.firstdata.service.IStudentService;
import cn.edu.ctbu.firstdata.service.impl.StudentServicelmp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
public class StudentServicelmpTest {
    @Autowired
    IStudentService studentServicelmp;

    @Test
    public void getAll() throws Exception {
        List<Student> myAll = studentServicelmp.getAll();
        Assertions.assertNotNull(myAll);
        System.out.println(myAll.size());
    }

    @Test
    public void findByName() {
        String name = "张三";
        List<Student> nameStudents = studentServicelmp.findByName(name);

        Assertions.assertNotNull(nameStudents);
    }

    @Test
    public void findByNameLike() {
        String name = "%ab%";
        List<Student> nameStudents = studentServicelmp.findByNameLike(name);
        Assertions.assertNotNull(nameStudents);
    }

    @Test
    public void findById() {
        Integer id = 1;
        Student student = studentServicelmp.findById(id);
        Student notstudent = studentServicelmp.findById(4);
        Assertions.assertNotNull(notstudent);

    }

    @Test
    public void getStudentScoreLess() {
        Integer score = 60;
        List<Student> nameStudnets = studentServicelmp.getStudentScoreLess(score);
        Assertions.assertNotNull(nameStudnets);
    }

    @Test
    public void findAllByPages() throws Exception {
        Pageable pageable = PageRequest.of(1, 1);
        Page<Student> myAll = studentServicelmp.findAll(pageable);
        Assertions.assertNotNull(myAll);
    }
    @Test
    public void delete(){
        Integer id=5;
        studentServicelmp.delete(id);
        Assertions.assertNotNull(studentServicelmp.findById(id));
    }
}