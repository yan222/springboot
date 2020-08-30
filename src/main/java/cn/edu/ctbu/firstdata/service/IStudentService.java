package cn.edu.ctbu.firstdata.service;

import cn.edu.ctbu.firstdata.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    public List<Student> getAll();

    public Page<Student> getAll(Pageable pageable);

    public List<Student> findByName(String name);

    public List<Student> findByNameLike(String name);

    public Student findById (Integer id);

    public List<Student> getStudentScoreLess(Integer score);

    public Student save(Student student);

    public void delete(Integer id);

    public void delete(Student student);

    public Page<Student> findAll(Pageable pageable);

    public Page<Student> findBySex(Integer sex,Pageable pageable);

    public Student validUserNameAndPassword(String username,String password) throws Exception;
}
